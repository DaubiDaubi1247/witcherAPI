FROM openjdk:17
ADD /target/braim-0.0.1-SNAPSHOT.jar witcher.jar
ENTRYPOINT ["java", "-jar", "witcher.jar"]