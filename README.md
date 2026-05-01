# SeleniumAdvancePractise Project Documentation

## Overview
This project is a comprehensive Selenium-based automation testing framework for **multiple web applications**. It demonstrates advanced Selenium practices across different testing scenarios including the QA Playground Bank application, OrangeHRM, and test pages for frame/file operations. The framework implements Page Object Model (POM), TestNG integration, and utility-driven architecture. The project is beginner-friendly with clear structure and progresses to advanced techniques like frame switching, file uploads/downloads, screenshot capture, custom utilities, and cross-browser testing capabilities.

**Multi-Application Testing Coverage:**
- **QA Playground Bank**: Modern banking application with dynamic UI components (https://qatesting.vercel.app/bank)
- **OrangeHRM**: Classic ERP system for HRM operations (https://opensource-demo.orangehrmlive.com)
- **Test Pages**: Advanced test scenarios including frames and file operations (https://testpages.eviltester.com)

## Technology Stack
- **Language**: Java (JDK 23)
- **Build Tool**: Maven
- **Testing Framework**: TestNG
- **Automation Tool**: Selenium WebDriver 4.32.0
- **Logging**: Log4j2
- **Additional Libraries**: Commons IO for file operations

## Project Structure
```
SeleniumAdvancePractise/
├── pom.xml                          # Maven configuration with dependencies
├── testng.xml                       # TestNG suite for general tests
├── testngforqaplayground.xml        # TestNG suite for QA Playground Bank tests
├── README.md                        # This documentation file
├── src/
│   ├── main/java/org/sdet/
│   │   └── Main.java                # Main class (basic entry point)
│   └── test/
│       ├── java/
│       │   ├── base/                # Base classes for test setup
│       │   │   ├── BaseTestClass.java       # Common setup/teardown for all tests
│       │   │   └── QAPlaygroundBankBaseClass.java # Future extension for QA Bank tests
│       │   ├── pages/               # Page Object classes
│       │   │   ├── LoginPage.java                  # OrangeHRM login page object
│       │   │   ├── DashboardPage.java             # OrangeHRM dashboard page object
│       │   │   ├── FrameTest.java                 # Advanced test scenarios (frames, uploads)
│       │   │   └── QAPlaygroundBank/
│       │   │       ├── QAPlaygroundLoginPage.java      # QA Bank login page
│       │   │       ├── QAPlaygroundDashboardPage.java  # QA Bank dashboard page (balance, accounts)
│       │   │       └── QAPlaygroundTransaction.java    # QA Bank transaction operations
│       │   ├── tests/               # Test classes
│       │   │   ├── DashboardPageTest.java              # OrangeHRM dashboard tests (empty template)
│       │   │   ├── QAPlaygroundLoginPageTest.java      # OrangeHRM login tests
│       │   │   └── QAPlaygroundBank/
│       │   │       ├── LoginTest.java                  # QA Bank login tests
│       │   │       └── DashboardTest.java              # QA Bank dashboard & transaction tests
│       │   └── utils/               # Utility classes
│       │       ├── BrowserUtil.java       # Browser-level operations (alerts)
│       │       ├── ElementUtil.java       # Element interaction wrapper with waits
│       │       └── LogicUtil.java         # Test logic helpers (random generation)
│       └── resources/
│           ├── log4j2.xml                 # Log4j2 configuration
│           ├── pagecontent.properties     # Application URLs, credentials, locators
│           ├── download/                  # Directory for downloaded files
│           │   └── screenshotProofForUpload0.png
│           └── upload/                    # Directory for uploaded files
│               └── screenshotForSeleniumUpload.png
└── target/                          # Generated compiled classes and artifacts
    ├── classes/
    ├── test-classes/
    └── site/apidocs/                # Javadoc documentation (if generated)
```

## Key Concepts and Techniques

### 1. Page Object Model (POM)
- **Beginner Level**: POM separates test logic from page-specific code. Each web page has a corresponding Java class with methods for interactions.
- **Implementation**: Classes like `QAPlaygroundTransaction.java` encapsulate locators and actions for the transaction page.
- **Benefits**: Improves maintainability, reduces code duplication, and makes tests more readable.

### 2. TestNG Framework
- **Beginner Level**: TestNG is a testing framework inspired by JUnit but with more features like parallel execution and data-driven testing.
- **Usage**: `@BeforeClass`, `@AfterSuite` annotations for setup/teardown. XML files (`testng.xml`) define test suites.
- **Advanced**: Supports groups, priorities, and listeners for complex test scenarios.

### 3. Selenium WebDriver
- **Beginner Level**: WebDriver controls browser programmatically. Methods like `findElement()`, `click()`, `sendKeys()`.
- **Advanced**: Explicit waits with `WebDriverWait`, handling dynamic elements, and modern UI components.

### 4. Utility Classes with Detailed Functionality

#### ElementUtil (Wrapper for Element Interactions)
Encapsulates common WebElement operations with built-in explicit waits:
- `getElement(By locator)`: Retrieves element with visibility wait
- `performClick(By locator)`: Clicks element with explicit wait
- `sendKeys(By locator, String text)`: Sends text with element clear before input
- `waitForElementVisible(By locator)`: Explicit wait for visibility
- `waitForElementClickable(By locator)`: Explicit wait for clickability
- `getElementText(By locator)`: Retrieves element text
- `clickCTA(By locator)`: Clicks call-to-action with clickability wait
- `getToastMessage(By locator)`: Retrieves toast notification content
- Default timeout: 10 seconds

#### BrowserUtil (Browser-Level Operations)
Handles browser-specific interactions:
- `getAlertText()`: Gets alert message text
- `acceptAlert()`: Accepts alert dialog
- `waitForAlert()`: Explicit wait for alert presence
- **Note**: Alert functionality is deprecated in QA Playground Bank; replaced with toast messages

#### LogicUtil (Test Logic Helpers)
Provides utility methods for test data generation:
- `randomNumberGenerator()`: Generates random number (0-2 range) for selecting random dropdown options
- Uses Log4j2 for logging generated random numbers

### 5. Configuration and Properties
- **Properties File**: `pagecontent.properties` stores test data, URLs, and configurable values.
- **Chrome Options**: Custom browser preferences to disable notifications and password prompts.

### 6. Logging Configuration and Usage

#### Log4j2 Setup
Configured via `src/test/resources/log4j2.xml`:
- **Console Appender**: Outputs logs to console
- **Pattern Format**: `%d{HH:mm:ss} %-5level %c{1} - %msg%n`
  - `%d{HH:mm:ss}` - Timestamp in HH:MM:SS format
  - `%-5level` - Log level (INFO, WARN, ERROR, etc.)
  - `%c{1}` - Simple class name
  - `%msg` - Log message
- **Default Level**: info (filters debug messages)

#### Using Logging in Code
```java
private static final Logger log = LogManager.getLogger(QAPlaygroundTransaction.class);
//log.info("From account dropdown option sizes: {}", fromAccountOptions.size());
```

#### Log Output Examples
```
14:23:45 INFO  LogicUtil - Generated random number is 1
14:23:46 INFO  ElementUtil - Waiting for element visibility
14:23:47 INFO  QAPlaygroundTransaction - Transaction submitted
```

### 7. Maven Build and Dependency Management
- **Build Tool**: Maven 3.6.0+ required
- **Lifecycle**: `mvn clean test` compiles and runs tests
- **Key Commands**:
  - `mvn clean` - Remove target directory
  - `mvn compile` - Compile source code
  - `mvn test` - Run all tests
  - `mvn test -Dtest=TestClassName` - Run specific test
  - `mvn javadoc:javadoc` - Generate API documentation
  - `mvn clean package` - Build and package project
- **Dependencies in pom.xml**:
  - Selenium for browser automation
  - TestNG for test execution
  - Log4j2 for logging
  - Commons IO for file operations

## Getting Started (Beginner Guide)
1. **Prerequisites**: Install JDK 23, Maven, IntelliJ IDEA or Eclipse.
2. **Clone/Setup**: Import the project as a Maven project.
3. **Dependencies**: Maven will automatically download all dependencies from `pom.xml`
4. **Run Tests**: Use `mvn test` or run TestNG XML files directly from IDE.
5. **Browser Setup**: Ensure ChromeDriver is compatible with your Chrome version (Selenium Manager handles this in v4+).
6. **First Test**: Start with `QAPlaygroundLoginPageTest.java` to understand basic flow.

## Learning Path (Beginner to Advanced)

### Beginner Level (Start Here)
1. Read `QAPlaygroundLoginPage.java` - Understand simple page object with locators and methods
2. Read `LoginTest.java` - Understand basic test structure and TestNG annotations
3. Run a simple test: `QAPlaygroundLoginPageTest.openBrowserAndNavigate()`
4. Learn: Basic Selenium operations (navigation, find elements, interactions)

### Intermediate Level
1. Study `BaseTestClass.java` - Understand WebDriver initialization and setup/teardown
2. Study `ElementUtil.java` - Understand explicit waits and wrapper patterns
3. Study `DashboardTest.java` - Understand multi-step workflows and assertions
4. Learn: Property file usage, explicit waits, test organization

### Advanced Level
1. Study `QAPlaygroundTransaction.java` - Understand complex page objects with multiple operations
2. Study `FrameTest.java` - Understand frame switching, file operations, screenshots
3. Study `QAPlaygroundLoginPage.java` - Understand advanced locator strategies
4. Learn: Custom UI handling, file operations, advanced Selenium APIs

### Expert Level
1. Customize utility classes for your needs
2. Extend to other browsers (Firefox, Safari, Edge)
3. Implement cross-browser testing
4. Add parallel execution capabilities
5. Integrate with CI/CD pipelines

## Troubleshooting Common Issues

### Issue: Tests fail with "Element not found"
- **Cause**: Locators changed or element not loaded
- **Solution**: Use browser DevTools to inspect elements and update locators in page objects

### Issue: "NoSuchElementException"
- **Cause**: Element doesn't exist or wait timeout too short
- **Solution**: Extend wait time in ElementUtil, verify locator is correct

### Issue: Tests pass locally but fail in CI/CD
- **Cause**: Timing issues or environment differences
- **Solution**: Increase explicit wait times, use headless mode for CI/CD

### Issue: StaleElementReferenceException
- **Cause**: Element is no longer attached to DOM
- **Solution**: Re-fetch element in each operation instead of caching

### Issue: Chrome not found
- **Cause**: ChromeDriver not installed or path not set
- **Solution**: Selenium 4.32.0+ has Selenium Manager bundled; ensure it's enabled

### Issue: Properties file not found
- **Cause**: File path construction issue
- **Solution**: Verify file exists at `src/test/resources/pagecontent.properties`

## Dependency Versions and Compatibility

| Dependency | Version | Notes |
|---|---|---|
| Java | 23 | Latest version, ensure local JDK matches |
| Selenium | 4.32.0 | Includes Selenium Manager for driver management |
| TestNG | 7.11.0 | Test framework for test organization and execution |
| Log4j2 | 2.25.4 | Latest stable, configured in log4j2.xml |
| Commons IO | 2.20.0 | File operations for upload/download |

## Extension Points

### Adding New Page Objects
1. Create new class in `src/test/java/pages/` package
2. Define locators as class variables
3. Define action methods
4. Use utility classes (ElementUtil, BrowserUtil) for interactions
5. Add constructor that accepts WebDriver and WebDriverWait

### Adding New Tests
1. Create test class extending `BaseTestClass`
2. Use `@Test` annotation with priority or dependencies
3. Instantiate page objects in test methods
4. Use assertions for verification
5. Add to appropriate suite in XML file

### Customizing Waits
- Modify default timeout in `ElementUtil` (currently 10 seconds)
- Use `waitForElementVisible()` for visibility requirements
- Use `waitForElementClickable()` for clickable requirements
- Create custom waits for specialized scenarios

### Multi-Browser Testing
The framework is designed for Chrome. To add Firefox:
1. Uncomment Firefox code in `BaseTestClass.java`
2. Add Firefox WebDriver dependency to `pom.xml`
3. Parameterize browser selection via properties or TestNG parameters
4. Ensure locators work across browsers (IDs and CSS preferred over XPath)

## Tips and Best Practices

### Tips for Better Tests
1. **Always use explicit waits** instead of `Thread.sleep()`
2. **Keep locators in one place** (class variables in page objects)
3. **Use descriptive method names** that explain what action is being performed
4. **One assertion per test** or use soft assertions for related validations
5. **Load properties files once** in base class to avoid multiple reads
6. **Log important steps** for debugging failed tests
7. **Use page object constructors** to initialize utilities consistently
8. **Test independent functionality** - avoid test dependencies when possible
9. **Use clear variable names** - avoid `x`, `y`, `temp`
10. **Comment complex logic** with TODO items for future improvements

### Common Pitfalls to Avoid
- ❌ Using `Thread.sleep()` for waits
- ❌ Hard-coding URLs and credentials in test code
- ❌ Storing too much logic in test methods
- ❌ Not handling exceptions gracefully
- ❌ Creating WebDriver without proper cleanup
- ❌ Using XPath when ID or CSS selector is available
- ❌ Assuming elements are present without waiting
- ❌ Running tests in parallel without thread-safe utilities
- ❌ Modifying global variables from multiple tests
- ❌ Not commenting out OR removing deprecated code

## FAQ (Frequently Asked Questions)

**Q: How do I add a new test?**
A: Create a test class in `tests/` package, extend `BaseTestClass`, create test methods with `@Test` annotation, instantiate page objects, and use assertions.

**Q: How do I modify application URLs?**
A: Edit `src/test/resources/pagecontent.properties` file. Update URLs for different environments (QA, staging, production).

**Q: How do I run only QA Playground Bank tests?**
A: Run command: `mvn test -DsuiteXmlFile=testngforqaplayground.xml`

**Q: How do I change the wait timeout?**
A: Modify `timeout` variable in `ElementUtil.java` (currently 10 seconds) or create custom waits.

**Q: Why is my test failing with "Element not found"?**
A: Likely causes: (1) Element hasn't loaded - increase wait time, (2) Locator is wrong - inspect element with DevTools, (3) Element is in iframe - switch to frame first.

**Q: How do I take screenshots?**
A: Use `TakesScreenshot` interface: `File screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);`

**Q: Can I use this for API testing?**
A: This framework is specific to UI testing with Selenium. For API testing, consider tools like RestAssured.

**Q: How do I run tests in parallel?**
A: Add parallel attributes to testng.xml: `<suite name="Suite" parallel="tests" thread-count="4">`

**Q: How do I handle dynamic elements?**
A: Use explicit waits with dynamic locators. Build XPath using data attributes or text content that changes.

**Q: What's the difference between hard assertions and soft assertions?**
A: Hard assertions (Assert) stop test execution on failure. Soft assertions (SoftAssert) collect failures and report at end.

## Version Control and Git Tips

### Recommended .gitignore entries
```
target/
*.class
.idea/
*.iml
.DS_Store
logs/
```

### Best practices
- Commit only source code, not compiled classes
- Document variable changes in commit messages
- Keep feature branches focused on single functionality
- Use meaningful commit messages

## Performance Optimization

### Test Optimization Tips
1. **Parallelize tests** - Run independent tests in parallel via TestNG
2. **Reduce waits** - Use appropriate waits (don't wait unnecessarily)
3. **Cache static data** - Load properties file once in base class
4. **Skip non-critical validations** - Focus on critical workflows
5. **Use beforeClass instead of beforeMethod** when setup is expensive
6. **Close unnecessary browser windows** - WebDriver manages resources

### Wait Time Optimization
- Critical operations: 10-15 seconds
- Standard operations: 5-10 seconds
- Fast UI: 3-5 seconds
- Adjust based on network speed and system load

## Contributing to the Project

### Adding new features
1. Create feature branch from main
2. Add page objects for new pages
3. Add utility methods for repeated patterns
4. Add comprehensive tests
5. Update this README with new features
6. Create pull request with detailed description

### Code Review Checklist
- [ ] Code follows existing style and patterns
- [ ] All methods have clear Javadoc comments
- [ ] No hard-coded values (use properties file)
- [ ] Proper exception handling
- [ ] Tests are independent and repeatable
- [ ] Performance is acceptable
- [ ] Documentation is updated

## Conclusion

This SeleniumAdvancePractise project provides a solid foundation for web UI automation testing. It demonstrates:
- ✅ Page Object Model for maintainable test code
- ✅ Explicit waits for reliable test execution
- ✅ Utility classes for code reusability
- ✅ Property-based configuration for flexibility
- ✅ Multiple test scenarios from basic to advanced
- ✅ Proper logging and error handling
- ✅ TestNG framework for test organization

By following the patterns and practices demonstrated here, you can build scalable and maintainable test automation frameworks for any web application.

For more information on technologies used:
- Selenium Official Docs: https://www.selenium.dev/documentation/
- TestNG Official Docs: https://testng.org/doc/
- Log4j2 Official Docs: https://logging.apache.org/log4j/2.x/
- Maven Official Docs: https://maven.apache.org/guides/








