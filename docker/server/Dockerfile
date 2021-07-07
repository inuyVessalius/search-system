FROM openjdk:11.0.11-jdk-oracle
COPY ./out/artifacts/server_jar/search-system.jar /tmp
WORKDIR /tmp
CMD ["java", "-jar", "search-system.jar"]