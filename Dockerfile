FROM openjdk:8
ADD target/sb-service-management.jar sb-service-management.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","sb-service-management.jar"]