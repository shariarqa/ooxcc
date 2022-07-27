FROM openjdk:19-jdk-alpine3.16

#Workspace
WORKDIR /oxccDocker

#ADD .JAR UNDER TARGET FROM THE HOST  IN TO THIS IMAGE
ADD target/ooxcc-docker.jar         ooxcc-docker.jar
ADD target/ooxcc-docker-tests.jar   ooxcc-docker-tests.jar
ADD target/dependency               dependency


#ADD SUITE
ADD Testing.xml                     Testing.xml

#make sure that local host ip address is at the @BeforeTEst class
ENTRYPOINT java -cp ooxcc-docker.jar:ooxcc-docker-tests.jar:dependency/* org.testng.TestNG Testing.xml