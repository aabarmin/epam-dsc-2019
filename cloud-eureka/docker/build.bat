@echo off
set currentDir=%cd%

echo Build new JARs
call %currentDir%\..\..\gradlew clean :cloud-eureka:composeUp -p %currentDir%\..\..
