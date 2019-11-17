FROM java:8-jre-alpine
EXPOSE 8080
ADD app.jar /opt/app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/opt/app.jar"]
