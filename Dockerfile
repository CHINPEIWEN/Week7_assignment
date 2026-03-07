FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/sum-product_fx-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
