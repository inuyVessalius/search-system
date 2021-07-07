FROM openjdk:11.0.11-jdk-oracle
COPY ./out/artifacts/search_system_jar/search-system.jar /tmp
WORKDIR /tmp
CMD ["java", "-jar", "search-system.jar", "127.0.0.1"]