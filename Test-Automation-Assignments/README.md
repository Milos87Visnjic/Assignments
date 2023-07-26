# ACCT-Test-Automation

# Cucumber BDD Framework

- Main programming language is Java.
- The automation tool is Selenium WebDriver 4.0.
- Test Script language is Gherkin.
- The built automation tool is Maven. 
- The assertion tool is JUnit.



Behavior Driven Development (BDD) approach to simplify reading and understanding the framework for the non-technical persons to increase reusability.
 - To implement this approach, there is a features package under the Resources directory. Test scripts are written as if they were scenarios from the end users’ perspective in Gherkin language in feature files under the features package.
- The actual coding logic inside of step_definitions package. 

#### There are two design patterns in the framework.
- The first one is the Page Object Model design pattern.
- The second one is the Singleton Design Pattern to allow the framework to use the same instance of webDriver in one session. 
#### Under the utility package, 
- BrowserUtils, 
- ConfigurationReader. 
    - ConfigurationReader class reads the configuration.properties file which is on the same level with pom.xml. There are test data that can change the running flow of the whole framework, such as environment url, browser type, username, password, and any text information in the project. ConfigurationReader opens the file and passes the path of the file into FileInputStream - loading the file to properties class object. 
- MongoUtils.
    - Enables to connect MongoDb and read the requested information from MongoDB collections.
- Runners package. 
    - The runner class triggers the framework. Runner class allows to run different types of testing suites that were created with the tags, such as smoke, regression or ticket numbers. 

#### Clone the App

- First Option
    - Git clone `git@github.com:avantageusa/ACCT-Test-Automation.git`
    - Open intellij IDEA
    - Click open
    - Browse cloned file
- Second Option:
  - Open intellij IDEA
  - Click “get from VCS”
  - Insert `git@github.com:avantageusa/ACCT-Test-Automation.git`
  - Click clone

#### Run Project:

- First Option(Project Menu)
  - Click Project at the top left corner
  - Click Project Name
  - Click SRC
  - Click test
  - Click Java
  - Click runners
  - Doble click on CukesRunners
  - Select the tag of the scenario 
    Eg: tags=”@login” (will run login scenario, )
  - Click on small triangle next to public class CkusRunner Or CTRL+R
- Second Option (CLi)
  - Install Maven on your computer
  - Click Terminal 
  - Enter the command `mvn test -Dcucumber.filter.tags=”@tagsName”`
- Third Option(Maven Menu)
  - Click on Maven Button at the  top right corner.
  - Click Lifecycle
  - Click test/verify
