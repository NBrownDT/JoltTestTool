FROM gradle:7.5.1-jdk17

EXPOSE 8080/tcp

COPY src src
COPY build.gradle build.gradle
RUN addgroup --system joltgroup && adduser --system jolt --ingroup joltgroup && chown jolt:joltgroup src \
 && chown jolt:joltgroup build.gradle && ls -al src

RUN gradle bootJar && rm -rf src && rm build.gradle && mv build/libs/gradle-1.0-SNAPSHOT.jar JoltTestTool.jar
# RUN ls build/libs

CMD ["java","-jar","JoltTestTool.jar"]
