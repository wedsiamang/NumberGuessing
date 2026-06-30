# =============================================================
#  numberguessing — Render 用 Dockerfile
# -------------------------------------------------------------
#  ・javax.servlet 系のため Tomcat 9 系を使用（10+ は jakarta で非互換）
#  ・Maven 構成ではないのでビルド済み WAR をそのまま載せる
#  ・WAR を「展開状態」で置くのは、起動時に
#    WEB-INF/classes/heroku.properties を環境変数から書き込むため
# =============================================================
FROM tomcat:9.0-jre11-temurin

# WAR 展開に使う unzip を導入（このイメージは JRE のため jar コマンドが無い）
RUN apt-get update && apt-get install -y --no-install-recommends unzip \
 && rm -rf /var/lib/apt/lists/*

# Tomcat 同梱のサンプルアプリを全部消し、ROOT を自分のアプリにする
RUN rm -rf /usr/local/tomcat/webapps/*

# ビルド済み WAR を ROOT/ に展開（.war のまま置かず、ディレクトリに解凍）
COPY app.war /tmp/app.war
RUN mkdir -p /usr/local/tomcat/webapps/ROOT \
 && unzip -q /tmp/app.war -d /usr/local/tomcat/webapps/ROOT \
 && rm /tmp/app.war

# 起動時に DB 接続情報を流し込むスクリプト
#  （Windows 編集由来の CRLF を除去してから実行権限を付与）
COPY entrypoint.sh /entrypoint.sh
RUN sed -i 's/\r$//' /entrypoint.sh && chmod +x /entrypoint.sh

# Render は待受ポートを $PORT で渡す（未設定なら 8080）
EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]
