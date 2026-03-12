# OpenCart Automation Framework

This project is a Java-based UI automation framework for the OpenCart demo application, with a current focus on the customer registration journey.

For portfolio purposes, this repository represents more than a set of Selenium scripts. It shows how I structure a maintainable test automation framework using the Page Object Model, service-layer abstractions, dynamic test data, reporting, screenshots, and reusable utilities.

## Project Overview

The framework automates key registration scenarios on the OpenCart demo site:

- Successful registration with mandatory fields
- Successful registration with newsletter opt-in
- Successful registration without newsletter subscription
- Validation checks for empty required fields
- Duplicate account validation
- Navigation to the registration page from multiple entry points

Application under test: `https://tutorialsninja.com/demo/`

## Why This Project Matters

This project demonstrates how I approach automation as an engineering problem, not just as a collection of test cases.

- I separated UI interactions into page objects to keep tests readable and maintainable.
- I added a service layer so business flows like registration stay reusable across tests.
- I used `ThreadLocal<WebDriver>` to support parallel-ready execution design.
- I built reporting and screenshot capture into the framework for easier debugging.
- I used Faker-based user generation to reduce duplicate-data issues in positive scenarios.

## Tech Stack

- Java 21
- Selenium WebDriver 4
- TestNG
- Maven
- Extent Reports
- Jackson
- JavaFaker

## Framework Design

### 1. Page Object Model

Page classes encapsulate locators and page actions for screens such as:

- Landing page
- Register page
- Login page
- Account page
- Account success page
- Newsletter subscription page

### 2. Service Layer

Services such as `RegisterService` keep tests focused on intent instead of low-level UI steps.

### 3. Factories and Test Data

- `DriverFactory` creates browser instances based on configuration
- `UserFactory` generates realistic user data for registration flows
- TestNG data providers support reusable negative test data

### 4. Reporting and Observability

- Extent Reports generate an HTML execution report
- Screenshots are captured for passed and failed tests
- Run folders are timestamped for traceability
- Custom test case IDs are included in reporting

### 5. Parallel-Ready Design

The framework uses thread-local driver management and a TestNG suite file with parallel configuration, which lays the groundwork for scalable execution as the suite grows.

## Project Structure

```text
OpenCart-Automation/
|-- config.properties
|-- pom.xml
|-- testng.xml
|-- reports/
|-- src/
|   |-- main/java/
|   |   |-- constants/
|   |   |-- core/
|   |   |-- factory/
|   |   |-- models/
|   |   |-- pages/
|   |   |-- services/
|   |   `-- utilities/
|   `-- test/java/
|       |-- core/
|       |-- data/
|       |-- dataproviders/
|       |-- listeners/
|       `-- tests/RegisterFunctionality/
`-- target/
```

## Configuration

Project configuration is controlled through `config.properties`:

```properties
URL=https://tutorialsninja.com/demo/
BROWSER=chrome
headless=true
```

Supported browser options in the framework:

- `chrome`
- `firefox`
- `edge`
- `safari`

## How to Run

### Prerequisites

- Java 21
- Maven
- A supported browser installed locally

### Compile

```bash
mvn clean compile
```

### Execute

You can run the TestNG classes from your IDE, or use:

```bash
mvn test
```

The suite definition for curated registration coverage lives in `testng.xml`.

Note: the framework compiles cleanly, but the repository still contains an unfinished email-verification scenario and some ongoing parallel-suite stabilization work. For portfolio walkthroughs, running individual TestNG classes from the IDE is the most reliable way to explore the project today.

## Reporting Output

When the listener-based suite is used, reports are generated inside the `reports/` directory using a timestamped run folder structure like:

```text
reports/RegisterTests Runs/TR-YYYY-MM-DD_HH-mm-ss/
```

Each run can include:

- `index.html` Extent report
- Test-level screenshots
- Run-specific execution artifacts

## Current Scope

Right now, the framework is centered on registration functionality. That makes the project intentionally focused and easy to extend into other OpenCart flows such as:

- Login
- Account management
- Product search
- Cart
- Checkout

## Current Improvements in Progress

This repository already shows a solid framework base, and there are a few clear next steps:

- Complete email-verification coverage for the registration flow
- Expand JSON-driven test data usage
- Stabilize all scenarios for consistently green parallel suite execution
- Add broader coverage beyond registration

## Portfolio Takeaway

This project highlights my ability to build a structured UI automation framework with reusable design patterns, readable tests, configurable execution, and report-driven feedback. It reflects how I think about test automation in a real project: maintainability first, then scale, visibility, and future extensibility.
