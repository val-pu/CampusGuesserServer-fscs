FROM openjdk:21

SHELL ["./gradlew","bootJar"]
SHELL ["echo","bootJar"]

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

