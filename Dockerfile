FROM amazoncorretto:21-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG TEMPLATES=src/main/resources/templates/*.html
COPY ${TEMPLATES} src/main/resources/templates/
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
