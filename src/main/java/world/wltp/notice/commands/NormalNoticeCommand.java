package world.wltp.notice.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.*;
import org.json.*;

public class NormalNoticeCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public NormalNoticeCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("importantnotice.use")) {
            sender.sendMessage(ChatColor.RED + "이 명령어를 사용할 권한이 없습니다.");
            return true;
        }

        if (!(sender instanceof Player player)) {
            sender.sendMessage("플레이어만 사용 가능");
            return true;
        }

        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                URL url = new URL("https://www.wltp.world/api/normal_notices/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) content.append(inputLine);
                in.close();

                JSONArray notices = new JSONArray(content.toString());

                if (args.length == 0) {
                    // 📋 리스트 출력 모드
                    player.sendMessage(ChatColor.YELLOW + "[일반공지 목록]");
                    for (int i = 0; i < notices.length(); i++) {
                        JSONObject notice = notices.getJSONObject(i);
                        player.sendMessage("" + ChatColor.GRAY + (i + 1) + ". " + ChatColor.GOLD + notice.optString("title", "제목 없음"));
                    }
                } else {
                    // 🔎 번호 입력 시 상세 공지 출력
                    try {
                        int index = Integer.parseInt(args[0]) - 1;
                        if (index >= 0 && index < notices.length()) {
                            JSONObject notice = notices.getJSONObject(index);
                            player.sendMessage(ChatColor.YELLOW + "[일반공지 - " + (index + 1) + "번]");
                            player.sendMessage(ChatColor.GOLD + notice.optString("title", "제목 없음"));
                            player.sendMessage(ChatColor.GRAY + notice.optString("content0", ""));
                            player.sendMessage(ChatColor.GRAY + notice.optString("content1", ""));
                        } else {
                            player.sendMessage(ChatColor.RED + "해당 번호의 공지가 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "숫자를 입력해주세요. 예: /일반공지 2");
                    }
                }

            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "공지 불러오기 실패!");
                e.printStackTrace();
            }
        });

        return true;
    }

}
