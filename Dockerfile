FROM schoolofdevops/voteapp-mvn:v0.1.0

WORKDIR /code

ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src/main /code/src/main
RUN ["mvn", "package"]

CMD ["java", "-jar", "target/vertx-blog-0.0.1-SNAPSHOT-fat.jar"]
