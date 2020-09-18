#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine as build

# Set the current working directory inside the image
WORKDIR /workspace/app

# Copy the pom.xml file
COPY pom.xml .
COPY src src

# Package the application
RUN apk add --no-cache maven
RUN mvn install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app 
FROM openjdk:8-jdk-alpine

ARG DEPENDENCY=/workspace/app/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.delanhese.corretora.CorretoraApplication"]