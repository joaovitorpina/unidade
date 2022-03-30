FROM eclipse-temurin:17-jdk
WORKDIR /home/app
COPY . .
RUN ls
RUN ./gradlew clean jar
COPY layers/libs /home/app/libs
COPY layers/classes /home/app/classes
COPY layers/resources /home/app/resources
COPY layers/application.jar /home/app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]