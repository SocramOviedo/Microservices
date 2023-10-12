FROM openjdk:8
EXPOSE 8080
ADD target/springboot-microservices.jar springboot-microservices.jar
ENTRYPOINT ["java","-jar","/springboot-microservices.jar"]