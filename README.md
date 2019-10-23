# Classified counter assignment
Spring boot application

a. Checkout the project from Github.

b. Make sure that your Maven environment is properly set to use JDK 1.8.

c. Navigate to the project's folder

d. Execute:

```bash
mvn clean install
```

e. The application will be built successfully and will also run the Unit tests with results:

```bash
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```

f. Also execute:

```bash
mvn spring-boot:run
```

in order to be able to send POST requests to:

```bash
http://localhost:8080/classified/count
http://localhost:8080/classified/countHtml
```

Notes:
1. Apart from the JUnit tests, the application was also tested with POSTMAN.
2. Unit tests were created for both Service and Controller beans.
2. The count method implementation is a simple function that follows the logic "split request body text at spaces and count all Strings whose length is bigger than 1". It is a generalization of all the provided rules that indeed provides the correct results. Another approach was to provide Regex expressions for each rule but I decided to use it only for the euro amount requirement and keep the rest simple.
