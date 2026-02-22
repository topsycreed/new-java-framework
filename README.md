# Template Automation Framework (Java, JUnit 5, REST Assured, Selenium, GitHub Actions, Jenkins)

Java workshop project for building an automation framework from scratch for API and UI testing, then running tests in CI.

This repository is a reference implementation for Bas Dijkstra automation project guideline: https://github.com/basdijkstra/a-test-automation-project

## Related workshop material

<a href="src/test/resources/images/Building a Test Automation Framework in Java from Scratch.png">
<img src="src/test/resources/images/Building a Test Automation Framework in Java from Scratch.png" alt="Masterclass preview" width="480" />
</a>

- 3 hours YouTube Masterclass: Building a Test Automation Framework in Java from Scratch: [English](https://www.youtube.com/watch?v=Uqbt9oY8ZX0) and [Russian](https://www.youtube.com/watch?v=5kPvJUzLr98)
- [Step-by-step Google Doc tutorial (English)](https://docs.google.com/document/d/1jtK563Ryqwd0i2qgYtvYr-1HGEp_kddLY69qB6_62Q4/edit?usp=sharing)
- [Step-by-step Google Doc tutorial (Russian)](https://docs.google.com/document/d/1ydqx5GVVoHwgLTm3MmRp5cqWjdc7xfzUJ1riePKHt_4/edit?usp=sharing) + [LinkedIn article (Russian)](https://www.linkedin.com/pulse/%25D0%25B0%25D0%25B2%25D1%2582%25D0%25BE%25D0%25BC%25D0%25B0%25D1%2582%25D0%25B8%25D0%25B7%25D0%25B0%25D1%2586%25D0%25B8%25D1%258F-uiapi-%25D1%2581-%25D0%25BD%25D1%2583%25D0%25BB%25D1%258F-%25D0%25B4%25D0%25BE-%25D0%25B3%25D0%25BE%25D1%2582%25D0%25BE%25D0%25B2%25D0%25BE%25D0%25B3%25D0%25BE-%25D1%2584%25D1%2580%25D0%25B5%25D0%25B9%25D0%25BC%25D0%25B2%25D0%25BE%25D1%2580%25D0%25BA%25D0%25B0-%25D0%25B2-cicd-chursov-zzuxc/?trackingId=IHUpECLmQ%2BiR%2B9BXTbf37g%3D%3D)

## Tech stack

- Java 17
- Gradle (wrapper included)
- JUnit 5
- Rest Assured
- Selenium WebDriver
- AssertJ
- Owner (property-based config)
- Allure (results + reports)
- GitHub Actions and Jenkins

## Project structure

```text
src/test/java
  config/        # Owner configuration interface
  constants/     # Shared constants
  controllers/   # API client/controller layer
  models/        # API models
  pages/         # Page Object Model classes
  testdata/      # Reusable test data
  tests/         # API and UI tests
  utils/         # JUnit extension + Allure attachments

src/test/resources
  default.properties
  dev.properties
  test.properties
```

## Prerequisites

- JDK 17+
- Git
- Google Chrome and matching ChromeDriver in PATH (for local UI runs)
- Docker Desktop (or Docker Engine + Compose) for remote UI runs and Jenkins walkthrough

## Quick start

```bash
git clone https://github.com/topsycreed/new-java-framework.git
cd new-java-framework
./gradlew clean test
```

On Windows PowerShell:

```powershell
.\gradlew.bat clean test
```

## Running tests

Run all tests:

```bash
./gradlew clean test
```

Run API tests only:

```bash
./gradlew clean test --tests "tests.ApiTests"
```

Run UI tests only:

```bash
./gradlew clean test --tests "tests.UiTests" --tests "tests.UiPomTests"
```

## Configuration

Configuration is loaded through Owner library from:

1. `classpath:${env}.properties`
2. `classpath:default.properties` (fallback)

Available keys (see `src/test/resources/*.properties`):

- `apiBaseUrl`
- `uiBaseUrl`
- `login`
- `password`
- `selenium.remote.url`

Runtime options:

- `-Denv=dev` or `-Denv=test` to choose environment file
- `-Dlogin=... -Dpassword=...` to override credentials from CI
- `-Dselenium.remote.url=http://selenium-hub:4444/wd/hub` to force remote WebDriver

The framework also supports `SELENIUM_REMOTE_URL` environment variable. If set, it is used before property-based Selenium URL lookup.

Example:

```bash
./gradlew clean test -Denv=dev -Dlogin=myLogin -Dpassword=myPassword -Dselenium.remote.url=http://localhost:4444/wd/hub
```

## Docker-based local infrastructure

`docker-compose.yml` starts:

- Jenkins at `http://localhost:8080`
- Selenium Grid Hub at `http://localhost:4444`
- Selenium Chrome node

Commands:

```bash
docker-compose up -d
docker-compose down
```

## CI/CD setup

### GitHub Actions

Workflow file: `.github/workflows/gradle.yml`

- Trigger: manual (`workflow_dispatch`)
- Uses JDK 17
- Starts a Selenium service container for UI tests
- Runs `./gradlew clean test`
- Builds and publishes Allure history to `gh-pages`

### Jenkins

Pipeline file: `Jenkinsfile`

- Uses Gradle 8.5 tool in Jenkins
- Runs tests with environment/system properties
- Publishes JUnit XML results
- Publishes Allure results from `build/allure-results`

## Workshop progression and branch map

The framework was developed incrementally. Each major stage is mapped to a branch.

| Step | Topic | Branch |
| --- | --- | --- |
| 1 | Choosing tech stack and environment setup | `master` (initial setup) |
| 2 | Creating a new project | `master` (initial setup) |
| 3 | Creating a GitHub repository | `master` (initial setup) |
| 4 | GitFlow and `.gitignore` | [`1-gitignore`](https://github.com/topsycreed/new-java-framework/tree/1-gitignore) |
| 5 | Adding Gradle dependencies | [`2-api`](https://github.com/topsycreed/new-java-framework/tree/2-api) |
| 6 | First API test (Rest Assured) | [`2-api`](https://github.com/topsycreed/new-java-framework/tree/2-api) |
| 7 | API refactoring (controller/model approach) | [`3-controller`](https://github.com/topsycreed/new-java-framework/tree/3-controller) |
| 8 | Constants and test data | [`4-constants`](https://github.com/topsycreed/new-java-framework/tree/4-constants) |
| 9 | Parameterized tests | [`5-parametrized`](https://github.com/topsycreed/new-java-framework/tree/5-parametrized) |
| 10 | First UI tests | [`6-ui`](https://github.com/topsycreed/new-java-framework/tree/6-ui) |
| 11 | Wait strategies | [`7-waits`](https://github.com/topsycreed/new-java-framework/tree/7-waits) |
| 12 | Page Object Model | [`8-pom`](https://github.com/topsycreed/new-java-framework/tree/8-pom) |
| 13 | Property files and CLI config | [`9-properties`](https://github.com/topsycreed/new-java-framework/tree/9-properties) |
| 14 | Allure reporting | [`10-allure`](https://github.com/topsycreed/new-java-framework/tree/10-allure) |
| 15 | CI/CD in GitHub Actions | [`11-github-actions`](https://github.com/topsycreed/new-java-framework/tree/11-github-actions) |
| 16 | CI/CD in Jenkins and Selenium Grid | [`12-jenkins`](https://github.com/topsycreed/new-java-framework/tree/12-jenkins) |

## Have any questions?
Write me here: [topsycreed@gmail.com](mailto:topsycreed@gmail.com) or [LinkedIn](https://www.linkedin.com/in/chursovg/)
