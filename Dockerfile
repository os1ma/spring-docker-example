FROM amazoncorretto:8u202

RUN groupadd -r -g 1000 app \
    && useradd -M -r -g app -u 1000 app
USER app
WORKDIR /app

COPY target/*.jar .

# *.jar を展開するために sh -c を実行し、
# さらに PID 1 で java プロセスを起動するため exec を使用
CMD ["sh", "-c", "exec java -jar *.jar"]
