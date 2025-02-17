# Cucumber BDD Automation Framework

##  Overview
This is a Selenium-based automation framework using Cucumber (BDD) with Java and Maven. It follows the Page Object Model (POM) to enhance maintainability and scalability.

##  Tech Stack
- **Java** (JDK 11+ recommended)
- **Selenium WebDriver**
- **Cucumber (BDD Framework)**
- **JUnit**
- **WebDriverManager** (for automatic driver setup)
- **Maven** (for dependency management)

##  Setup and Installation
### 1 Prerequisites
- Install **Java (JDK 11+)**
- Install **Maven**
- Install **IntelliJ IDEA / Eclipse** (Recommended IDEs)

### 2 Clone the Repository
```sh
git clone https://github.com/*****
cd cucumber-bdd-framework
```

### 3️ Install Dependencies
```sh
mvn clean install
```

### 4️ Run the Tests
```sh
mvn test
```

##  Running Tests
### Using Maven:
```sh
mvn test
```

### Running via TestRunner:
Run `TestRunner.java` in the `com.automation.runners` package.


##  Reporting
After running tests, reports are generated in:
```
target/cucumber-reports.html
```