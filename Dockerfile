#Local build: docker build -t perfumeriasloli:local .
#Local run: docker run -p 8080:8080 perfumeriasloli:local
FROM openjdk:11.0.4-jre-slim

ARG COMMIT_ID="0"

WORKDIR /home/project

COPY target/perfumeriasloli-1.0-SNAPSHOT.jar app.jar

# This Java configuration is for local running with Docker, not for Kubernetes
ENV JAVA_TOOL_OPTIONS "\
-XX:+UseG1GC \
-XX:+PrintGC \
-Xss256k \
-Xms1500M \
-Xmx1500M \
-Dfile.encoding=UTF-8 \
-Djava.security.egd=file:/dev/urandom \
-Dspring.application.name=perfumerias-loli \
-Dspring.profiles.active=fat"

EXPOSE 8080

ENTRYPOINT java -jar app.jar
