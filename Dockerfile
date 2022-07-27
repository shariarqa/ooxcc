FROM openjdk:19-jdk-alpine3.16

RUN apk add curl jq

#Workspace
WORKDIR /oxccDocker

#ADD .JAR UNDER TARGET FROM THE HOST  IN TO THIS IMAGE
ADD target/ooxcc-docker.jar         ooxcc-docker.jar
ADD target/ooxcc-docker-tests.jar   ooxcc-docker-tests.jar
ADD target/dependency               dependency


#ADD SUITE
ADD Testing.xml                     Testing.xml
ADD healthcheck.sh                  healthcheck.sh
RUN dos2unix healthcheck.sh

#make sure that local host ip address is at the @BeforeTEst class
ENTRYPOINT sh healthcheck.sh