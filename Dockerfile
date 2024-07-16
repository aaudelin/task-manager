FROM amazoncorretto:21.0.3
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main ./src/main
COPY gradle/ ./gradle
COPY build.gradle.kts ./
COPY settings.gradle.kts ./
COPY gradlew ./
RUN ./gradlew build
RUN mv build/libs/*.jar task-manager.jar
ENTRYPOINT ["java","-jar","task-manager.jar"]
