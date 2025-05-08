
# EbayAutomation

## Overview
EbayAutomation is a Java-based test automation project for validating the eBay purchase flow using Selenium WebDriver, TestNG, and WebDriverManager. The project automates navigation to the "Cell Phones & Accessories" category, selects a product, adds it to the cart, and verifies product details (name and price) in the cart. Due to eBay’s recent UI changes (as of May 2025), the project handles the "See All" link and accounts for the account login requirement for cart actions.

### Features
- **Page Object Model (POM)**: Modular page classes (`HomePage`, `SearchResultsPage`, `ProductDetailsPage`, `CheckoutPage`, `UserSelectorModal`) for maintainability.
- **Centralized WebDriver Management**: Uses `WebDriverFactory` and `DriverManager` with `ThreadLocal` for thread-safe browser sessions.
- **Dynamic Waits**: `WaitUtil` handles element visibility and clickability with configurable timeouts.
- **Logging**: Log4j2 logs test execution details to `logs/automation.log` for debugging.
- **Reporting**: ExtentReports generates HTML reports in `target/extent-reports/ExtentReport.html`.
- **Retry Logic**: `RetryAnalyzer` retries failed tests to handle transient failures.
- **Browser Testing**: Supports Firefox via TestNG’s `testng.xml`.

## Prerequisites
- **Java**: JDK 21 or higher
- **Maven**: 3.8.7 or higher
- **Browsers**:
  - Firefox (latest stable version)
- **IDE**: NetBeans, IntelliJ IDEA, or Eclipse (optional)
- **Git**: For cloning the repository

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/EbayAutomation.git
   cd EbayAutomation
   ```

2. **Install Dependencies**:
   - Ensure Maven is installed (`mvn --version`).
   - Run:
     ```bash
     mvn clean install
     ```
   - This downloads dependencies (Selenium, TestNG, WebDriverManager, Log4j2, ExtentReports) defined in `pom.xml`.

3. **Verify Browser Installation**:
   - **Firefox**: Run `firefox --version`. If not installed, download from [mozilla.org/firefox](https://www.mozilla.org/firefox).
   - If browsers are in non-standard locations, update `WebDriverFactory.java`:
     ```java
     options.setBinary("/path/to/chrome");
     ```

4. **Configure Project**:
   - **Config Properties**: Edit `src/main/resources/config.properties` for timeouts or base URL:
     ```properties
     baseUrl=https://www.ebay.com
     waitTimeout=10
     ```
   - **Log4j2**: Logging is configured in `src/main/resources/log4j2.xml`. Logs are saved to `logs/automation.log`.

## Running Tests
1. **Via IDE**:
   - Open the project in NetBeans/IntelliJ/Eclipse.
   - Right-click `src/test/resources/testng.xml` > Run.
   - Tests run in parallel for Chrome and Firefox.

2. **Via Maven**:
   ```bash
   mvn clean test
   ```

3. **Test Flow**:
   - Navigates to eBay’s homepage.
   - Selects "Electronics" > "Smartphones and accessories" > "See All".
   - Picks the first product, clicks Buy it now.
   - Select Checkout as Guest from the dialog box.
   - Verifies product name and price in the cart.
   - Stops after adding basic customer informations.

4. **Outputs**:
   - **Logs**: `logs/automation.log` (e.g., element interactions, errors like “Account login required”).
   - **Reports**: `target/extent-reports/ExtentReport.html` (test results with pass/fail status).
   - **Console**: Test execution details.

## Project Structure
```
EbayAutomation/
├── src/
│   ├── main/
│   │   ├── java/com/lahirucw/ebayautomation/
│   │   │   ├── pages/               # Page Object classes (HomePage, SearchResultsPage, etc.)
│   │   │   ├── utilities/           # Helper classes (DriverManager, WebDriverFactory, WaitUtil, LoggerUtil)
│   │   ├── resources/
│   │       ├── config.properties    # Configuration (base URL, timeouts)
│   │       ├── log4j2.xml           # Log4j2 configuration
│   ├── test/
│   │   ├── java/com/lahirucw/ebayautomation/tests/
│   │   │   ├── BaseClass.java       # Test setup and teardown
│   │   │   ├── EbayPurchaseTest.java # Test case for purchase flow
│   │   │   ├── RetryAnalyzer.java   # Retry logic for failed tests
│   │   ├── resources/
│   │       ├── testng.xml           # TestNG suite configuration
├── logs/
│   ├── automation.log               # Runtime logs
├── target/
│   ├── extent-reports/
│   │   ├── ExtentReport.html        # Test report
├── pom.xml                          # Maven dependencies
├── README.md                        # This file
```

## Limitations
- **eBay Account Requirement**: As of May 2025, eBay requires a signed-in account to add items to the cart or view cart contents.
- **Network Dependence**: Tests require a stable internet connection to access eBay.

## Troubleshooting
- **Dependencies Missing**:
  - Delete `~/.m2/repository` and run `mvn clean install`. or
  - run `mvn clean dependency:resolve -U` to force resolve dependency issues.


## Contributing
- Fork the repository.
- Create a feature branch (`git checkout -b feature/YourFeature`).
- Commit changes (`git commit -m "Add YourFeature"`).
- Push to the branch (`git push origin feature/YourFeature`).
- Open a pull request.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact
For issues or questions, create a GitHub issue or contact the project maintainer at [as2021356@sci.sjp.ac.lk].