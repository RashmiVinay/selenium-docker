FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/Rashmi_Docker

# ADD .jar under target location from host
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# ADD suite files 
ADD TestData.xml TestData.xml

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* - DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

