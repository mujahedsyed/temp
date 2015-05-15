### Application developed on System with:
 - jdk 1.7
 - Apache Maven 3.3.1

### Run the project:
 - execute mvn test for all tests to run.

### Project Architecture 

#### Patterns used:
 - State pattern is used to maintain the state of vending machine.
 - Singleton pattern is used in Products class.
 - TDD is demonstrated throughout the development of the application.
 - Enums used for Constants like product and coin.
 - BigDecimal has been used for money calculations 
 - Logging: Log4j configuration is provided but has not been used as log4j dependency might not be available in end system. Ideally I would use log4j2.

### JavaDoc
 - create javadoc by executing mvn javadoc:javadoc command, reports can be accessed from target/site/apidocs/index.html 
