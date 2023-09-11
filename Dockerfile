FROM maven:3.6.3-openjdk-17

COPY src home/framework/src

COPY ExtentReport.html home/framework/extentreport.html

COPY pom.xml home/framework/pom.xml

COPY testng.xml home/framework/testng.xml

WORKDIR home/framework

## Running tests
RUN mvn clean test

