FROM openjdk:17
EXPOSE 9111
ADD target/hospital-doctors-data.jar hospital-doctors-data.jar
ENTRYPOINT ["java","-jar","/hospital-doctors-data.jar"]