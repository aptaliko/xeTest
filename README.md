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
