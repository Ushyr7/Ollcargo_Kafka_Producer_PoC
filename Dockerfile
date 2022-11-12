# define base docker image
FROM openjdk:11
LABEL maintainer="ollcargo"
ADD target/poc-0.0.1-SNAPSHOT.jar PoC
ENTRYPOINT ["java", "-jar", "PoC"]