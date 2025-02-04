# Selenium Test Automation with TestNG

## 📌 Project Overview
This project automates test scenarios for the **Demo Web Shop** (https://demowebshop.tricentis.com/) using **Selenium WebDriver, TestNG, and the Page Object Model (POM)**. The test suite includes:

✅ **User Registration**  
✅ **User Login**  
✅ **Product Search & Add to Cart**  
✅ **Checkout Process**

The project follows best practices such as the **Singleton Design Pattern** for WebDriver instance management and **POM for maintainability**.

---
## 🛠️ Tech Stack
- **Java** (Programming Language)
- **Selenium WebDriver** (UI tricentis)
- **TestNG** (Test Framework)
- **Maven** (Build & Dependency Management)
- **WebDriverManager** (Driver Management)
- **Page Object Model (POM)** (Maintainable Test Structure)

---
## 📂 Project Structure
```
SeleniumProject/
│── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.tricentis/
│   │   │   │   ├── base/ (Singleton WebDriver)
│   │   │   │   │   ├── WebDriverSingleton.java
│   │   │   │   ├── pages/ (Page Object Model)
│   │   │   │   │   ├── RegistrationPage.java
│   │   │   │   │   ├── LoginPage.java
│   │   │   │   │   ├── SearchPage.java
|   |   |   |
│   │   │   ├── com.tricentis.tests/ (Test Cases)
│   │   │   │   ├── RegistrationTest.java
│   │   │   │   ├── SearchTest.java
│── pom.xml (Maven Dependencies)
│── testng.xml (TestNG Suite)
│── README.md
```

---
## 🔧 Setup & Installation
### 1️⃣ **Prerequisites**
- Install **Java 11+**
- Install **Maven**
- Install **VS Code / IntelliJ IDEA**

### 2️⃣ **Clone the Repository**
```sh
git clone <repository-url>
cd SeleniumProject
```

### 3️⃣ **Run the Tests**
To execute all test cases, run:
```sh
mvn test
```

Alternatively, you can execute specific tests using TestNG:
```sh
mvn surefire:test -Dtest=RegistrationTest
```

---
## 🏗️ Key Components
### **1️⃣ WebDriver Singleton (Base Class)**
- Ensures only **one instance** of WebDriver is used throughout test execution.
- Located in `com.tricentis.base.WebDriverSingleton.java`

### **2️⃣ Page Object Model (POM)**
- Each page is represented by a separate class.
- Contains locators and methods for interacting with page elements.
- Located in `com.tricentis.pages`.

### **3️⃣ TestNG Test Cases**
- Uses `@BeforeClass`, `@Test`, and `@AfterClass` annotations.
- Located in `com.tricentis.tests`.

---
## 📜 Writing New Test Cases
1. **Create a new Page Object Class** in `com.tricentis.pages`.
2. **Define locators** using `By` class.
3. **Create methods** to perform actions.
4. **Write a TestNG test** in `com.tricentis.tests`.
5. **Add the test to `testng.xml`** for execution.

---
## 🚀 TestNG Suite Configuration (`testng.xml`)
```xml
<suite name="DemoWebShop Tests">
    <test name="E-Commerce Tests">
        <classes>
            <class name="com.tricentis.tests.RegistrationTest"/>
            <class name="com.tricentis.tests.SearchTest"/>
        </classes>
    </test>
</suite>
```

---
## 🛠️ Debugging & Troubleshooting
| Issue | Solution |
|--------|----------|
| WebDriver not launching | Ensure ChromeDriver is installed & WebDriverManager is set up |
| `NoSuchElementException` | Verify element locators in the Page Object Model |
| Test fails unexpectedly | Add `Thread.sleep(2000)` (for debugging, not recommended for production) |

---
## 📌 Conclusion
This project provides a scalable **Test Automation Framework** using **Selenium & TestNG**. It ensures **reusability, maintainability, and efficient WebDriver management**.

📢 **Feel free to contribute or report issues!**

## 📌 Output
Please refer to the folder outputVideo to see the video of the project run output.

---
✅ **Author**: Anjali  
📅 **Last Updated**: February 2025


