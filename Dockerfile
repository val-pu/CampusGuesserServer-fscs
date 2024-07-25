FROM openjdk:21

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 5432

ENTRYPOINT ["java","-jar","/app.jar"]

