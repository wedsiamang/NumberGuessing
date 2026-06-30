#!/bin/sh
set -e

# -------------------------------------------------------------
#  DB 接続情報を「環境変数 → heroku.properties」に変換して書き出す。
#  こうすると Neon のパスワードを公開リポジトリに残さずに済む
#  （アプリ側は ResourceBundle.getBundle("heroku") で読むので、
#   置き場所は WEB-INF/classes/heroku.properties で固定）。
# -------------------------------------------------------------
CLASSES_DIR=/usr/local/tomcat/webapps/ROOT/WEB-INF/classes
cat > "$CLASSES_DIR/heroku.properties" <<EOF
jdbc_url=${JDBC_URL}
db_user=${DB_USER}
db_pass=${DB_PASS}
EOF

# -------------------------------------------------------------
#  Render が渡す $PORT で Tomcat を待ち受ける（ローカルは 8080）。
#  server.xml の Connector port="8080" を $PORT に置換。
# -------------------------------------------------------------
PORT="${PORT:-8080}"
sed -i "s/port=\"8080\"/port=\"${PORT}\"/" /usr/local/tomcat/conf/server.xml

exec catalina.sh run
