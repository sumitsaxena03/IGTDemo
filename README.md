# Selenium-RestAssured-Framework

This is combined Web and API framework using Selenium and RestAssured.

Extent Report is used for reporting purpose. Docker is used for containerization with Dockerfile as well as "BrowserInDocker" feature of WebDriverManager.

Test can be pushed to Elastic Search and then visulized through Kibana dashboard. This is config base feature. Note: Elastic and Kibana setup has to be done before running the test. This can be done by running docker compose file attached in this project.

Test execution can be controlled through excel file which is implemented using IMethodInterceptor Listener..

Other used libraries: WebDriverManager(for driver management), lombok(for pojo building), jackson-databind(for serialization), Owner's library(for reading property file), apache poi(to read excel file), assertj(for test assertions), javafaker(to generate fake data).
