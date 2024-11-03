# DVLA-Technical-acceptance-tests
This project is about DVLA-Technical tests task.
It is hosted on Github in public repository
https://github.com/sushantbtavrawala/DVLA-Technical-Test

### Prerequisites
Ensure you have the following installed:

- Java 11 or higher
- Maven (for dependency management and build automation)
- Intellij Code Editor with the plugin from marketplace cucumber-java

### Browser
- By default the tests will run in Chrome browser

### Install dependencies
```mvn clean install```

### To run test with TestRunner
- Navigate to ```src/test/java/runnerClass```
- run the class ```public class TestRunner```

### To run specific tests with TAGS
- Navigate to ```src/test/java/runnerClass```
- add the name in for ex ```tags = "@smoke"```
- add the similar name on top of the tests for ex.  
- ```@smoke``` 
- ```Scenario: 01- Verify the quota limits are displayed```

### To run the tests with command line
```mvn clean install test -Dtest=TestRunner```
or run the shell script
```run_Tests.sh```

### Writing Tests
- ```Feature Files:``` Scenarios are written in .feature files under ```src/test/resources/features```
- ```Step Definitions:``` Implement step definitions in Java under ```src/test/java/stepDefinitions```
- ```Page Objects:``` Use the Page Object Model (POM) pattern under ```src/test/java/pages``` to create reusable web elements and actions

### Reports
- Reports are generated under ```target/Index.html```
- To view the report, open the ```Index.html``` file in a web browser




