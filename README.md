# WltpNoticeFetcher

This is a Spigot plugin that fetches notices from the [IMPERIUM SERVER official website](https://www.wltp.world/) for Minecraft servers.

마인크래프트 서버에서 [IMPERIUM SERVER 공식 웹사이트](https://www.wltp.world/)의 공지사항을 가져오는 Spigot 플러그인입니다.

---

## 🧩 주요 기능 / Features

- `/중요공지` : 중요 공지 전체 목록을 확인하거나, 번호를 입력하여 특정 공지를 확인할 수 있습니다.  
  `/ImportantNotice` : View the list of important notices or check details by specifying the number.

- `/일반공지` : 일반 공지를 확인합니다.  
  `/NormalNotice` : View the list of normal notices.

- `/아카이브공지` : 아카이브된 공지를 확인합니다.  
  `/ArchivedNotice` : View the list of archived notices.

공지 데이터는 비동기 처리되어 서버 렉 없이 불러옵니다.  
Notice data is fetched asynchronously to prevent server lag.

---

## 📦 설치 방법 / Installation

1. 이 저장소를 클론하거나 릴리즈된 JAR 파일을 다운로드합니다.  
   Clone this repository or download the released JAR file.

2. 서버의 `plugins/` 폴더에 JAR 파일을 넣습니다.  
   Place the JAR file into your server's `plugins/` folder.

3. 서버를 재시작하거나 명령어로 플러그인을 적용합니다.  
   Restart the server or load the plugin with commands.

---

## ⚙️ 명령어 / Commands

| 명령어                 | 설명                          | Command              | Description                                  |
|------------------------|------------------------------|----------------------|----------------------------------------------|
| `/중요공지`             | 중요 공지 전체 목록을 확인          | `/ImportantNotice`    | View all important notices                    |
| `/중요공지 <번호>`      | 특정 중요 공지 내용을 자세히 확인      | `/ImportantNotice <#>`| View details of a specific important notice  |
| `/일반공지`             | 일반 공지 전체 목록을 확인            | `/NormalNotice`       | View all normal notices                        |
| `/일반공지 <번호>`      | 특정 일반 공지 내용을 자세히 확인      | `/NormalNotice <#>`   | View details of a specific normal notice      |
| `/아카이브공지`         | 아카이브 공지 전체 목록을 확인         | `/ArchivedNotice`     | View all archived notices                      |
| `/아카이브공지 <번호>`  | 특정 아카이브 공지 내용을 자세히 확인    | `/ArchivedNotice <#>` | View details of a specific archived notice    |

---

## 🔐 퍼미션 / Permissions

| 퍼미션           | 기본값 | 설명                           | Permission      | Default | Description                   |
|------------------|--------|------------------------------|-----------------|---------|-------------------------------|
| `notice.use`     | `true` | 모든 명령어 사용 허용              | `notice.use`    | `true`  | Allows usage of all commands   |

LuckPerms 등으로 사용자 그룹에 할당할 수 있습니다.  
You can assign permissions to user groups using LuckPerms or similar plugins.

---

## 🛠️ 개발 정보 / Development Info

- **Java 버전 / Java Version**: 21  
- **Spigot API 버전 / Spigot API Version**: 1.21  
- **의존성 없음 / No External Dependencies**: 외부 라이브러리 없이 동작  
- **빌드 시스템 / Build System**: Maven (`maven-shade-plugin` 사용 / using `maven-shade-plugin`)

---

## 🌐 API 출처 / API Source

- `https://www.wltp.world/api/important_notices/`  
- `https://www.wltp.world/api/normal_notices/`  
- `https://www.wltp.world/api/archived_notices/`  

JSON 형식의 공지 데이터를 받아와 표시합니다.  
Fetches notices data in JSON format for display.

---

## 📄 라이선스 / License

본 플러그인은 [IMPERIUM SERVER](https://www.wltp.world/) 전용으로 개발되었습니다. 무단 수정 및 배포는 금지됩니다.  
This plugin is developed exclusively for [IMPERIUM SERVER](https://www.wltp.world/). Unauthorized modification and distribution are prohibited.

---

## 👤 개발자 / Developer

- **WLTP**  
- [https://www.wltp.world/](https://www.wltp.world)
