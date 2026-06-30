# =============================================================
#  numberguessing — Render 用 Dockerfile
# -------------------------------------------------------------
#  ・このアプリは javax.servlet 系。よって Tomcat は 9 系を使う
#    （Tomcat 10+ は jakarta.servlet になり、javax アプリは起動時に壊れる）
#  ・Maven 構成ではない（Eclipse 手動エクスポートの WAR）ので、
#    ビルド済み WAR をそのまま載せる
#  ・WAR を「展開状態」で置くのは、起動時に
#    WEB-INF/classes/heroku.properties を環境変数から書き込むため
# =============================================================
FROM tomcat:9.0-jre11-temurin

# Tomcat 同梱のサンプルアプリを全部消し、ROOT を自分のアプリにする
RUN rm -rf /usr/local/tomcat/webapps/*

# ビルド済み WAR を ROOT/ に展開（.war のまま置かず、ディレクトリに解凍）
COPY app.war /tmp/app.war
RUN mkdir -p /usr/local/tomcat/webapps/ROOT \
 && cd /usr/local/tomcat/webapps/ROOT \
 && jar -xf /tmp/app.war \
 && rm /tmp/app.war

# 起動時に DB 接続情報を流し込むスクリプト
#  （Windows 編集由来の CRLF を除去してから実行権限を付与）
COPY entrypoint.sh /entrypoint.sh
RUN sed -i 's/\r$//' /entrypoint.sh && chmod +x /entrypoint.sh

# Render は待受ポートを $PORT で渡す（未設定なら 8080）
EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]
