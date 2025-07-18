package world.wltp.notice;

import world.wltp.notice.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class NoticePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // 커맨드 등록
        getCommand("중요공지").setExecutor(new ImportantNoticeCommand(this));
        getCommand("일반공지").setExecutor(new NormalNoticeCommand(this));
        getCommand("아카이브공지").setExecutor(new ArchivedNoticeCommand(this));
        getLogger().info("공지 플러그인이 활성화되었습니다.");
    }

    @Override
    public void onDisable() {
        getLogger().info("공지 플러그인이 비활성화되었습니다.");
    }
}
