@echo off
set currentDir=%cd%

del /f %currentDir%\app.jar

echo Build new JAR
call %currentDir%\..\..\gradlew clean :basic-microservice:build -p %currentDir%\..\..
copy %currentDir%\..\build\libs\basic-microservice.jar %currentDir%\app.jar

echo Create docker image
docker container stop basic-microservice
docker container rm basic-microservice
docker image rm -f epam-training/basic-microservice
docker build -t epam-training/basic-microservice .

echo Running microservice
docker run -p 8080:8080 --name basic-microservice epam-training/basic-microservice
