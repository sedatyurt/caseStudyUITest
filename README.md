# caseStudyUITest

### Requirements

- JDK 16
- Maven

### Before Run

If you don't want to run in parallel, you can set **parallel** to **false** in the **src/test/java/cucumberoptions/TestNGTestRunner.java** file.

### How to Run

- `mvn clean install -DskipTests=true`
- `mvn clean verify -am -Dsurefire.suiteXmlFiles=src/test/resources/test-suite.xml -Dapi=java -Dtestng.dtd.http=true`
- `mvn allure:report -Dallure.results.directory=src/target/allure-results/`


### Test Reports
You can find the test reports and screenshots at **target/site/allure-maven-plugin/index.html**


### Used Technologies

- Selenium
- Maven
- TestNG
- Cucumber
- Allure Reports
