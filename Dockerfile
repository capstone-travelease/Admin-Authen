FROM openjdk:21

VOLUME /tmp

COPY target/*.jar auth-service-0.0.1-SNAPSHOT.jar

EXPOSE 2910
ENTRYPOINT ["java","-jar","/auth-service-0.0.1-SNAPSHOT.jar"]