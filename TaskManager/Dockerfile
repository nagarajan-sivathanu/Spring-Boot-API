#Base Image 
FROM openjdk:8-jdk-alpine

#Add the jar file from target folder to container
ADD  target/com.learn.taskmanager-0.0.1-SNAPSHOT.jar taskmanager.jar

#Entry Point Details
ENTRYPOINT ["sh","-c","java -jar /taskmanager.jar"]

