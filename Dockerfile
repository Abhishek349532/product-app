FROM anapsix/alpine-java:8

COPY target/product-app-0.0.1-SNAPSHOT.jar /product-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/product-app.jar"]
