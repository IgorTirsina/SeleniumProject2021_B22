JUNE 23RD, WEDNESDAY

TODAY'S SCHEDULE:
- REVIEW
- Actions practice
- Page Object Model Design Pattern

------------------------------------------------------------------------------------------

--> configuration.properties
- Why are we using this file
    - REUSABILITY
    - Easy to maintain
    - To avoid hard coding some of the important test data in our project

- What kind of data we are storing in configuration.properties?
    - We store the important test data that can change the flow of the whole test suite
    - We store the data in key=value format

    - browser=chrome
    - env/url
    - username=tester2
    - password=test

- What is cross browser testing?
    - Testing the same test suite against different browsers.
    - We are able to do cross-browser testing by changing our test data (browser key) from configuration.property

- What is DATA DRIVEN TESTING? (DDT)
    - Running the same tests against different test data.

ex:
test1
- username: tester1
- password: test

	test1
		- username: tester2
		- password: test
		

	test1
		- username: tester3
		- password: test	

------------------------------------------------------------------------------------------

What is ConfigurationReader.java?
- ConfigurationReader is a utility class we created.

Why did we create this class?
- REUSABILITY of the logic where we read from configuration.properties file.
- We created .getProperty method in this utility class, so we don't have to repeat the logic to read from configuration.reader class
- All we have to do is to call the method and pass "key" to get "value" from configuration.properties


How do we read from properties file?
#1- Create an object of Properties class
Properties properties = new Properties();

	#2- Open the ".properties" file using FileInputStream and its object 
		FileInputStream file = new FileInputStream("pathOfTheFileWeAreTryingToOpen");

	#3- Use FileInputStream object to load .properties file into Properties object.
		properties.load(file);

	#4- Use properties.getProperty method to read specific key and value.
		properties.getProperty("key") --> value
		properties.getProperty("browser") --> chrome

------------------------------------------------------------------------------------------

	- TestBase:
		- Is TestBase a utility class?
		- No.
		- TestBase is an abstract class where we store and re-use some repeating logic and common variables.
		- TestBase is parent of all other tests we create in a project.
		- If we decide to use TestBase, we would have to extend to TestBase from all the classes we have tests in.

		- If we have a logic that applies all of the tests in our testing suite, we can use TestBase.


------------------------------------------------------------------------------------------


	- JavaScriptExecutor:
		- What is it?
		- Simple interface from Selenium library.
		- It has two methods.

		- What does it do?
		- The methods in this interface allows us to simply execute JavaScript code in our Java+Selenium project.

		- Can we only scroll using JavaScriptExecutor?
		- No. Basically we can pass any JavaScript code in our Java+Selenium.



--> How many different ways you can scroll?
1- Actions method called .moveToElement()
2- sendKeys(Keys.PAGE_DOWN) or sendKeys(Keys.PAGE_UP)
3- scroll using JavaScriptExecutor:
js.executeScript("window.scrollBy(0, 750)");

	4- OPTION 2 FOR JSEXECUTOR:
		js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);
	
===========================================================================

--> Page Object Model Design Pattern
-> What is Page Object Model Design Pattern?
- Creating java class for each page of the web application we are working on
- We store relevant webElement, methods into its own java class.


- How do we implement POM Design Pattern?
  #1- Every time we create a new java class for each page of the application we need to initialize the browser driver instance and the object of that specific class.

    - We need to pass: PageFactory.initElements(driver, this);


	#2- Instead of using findElement/s we use @FindBy annotation


Smartbear
- LoginPage.java
- username
- password
- signIn button
- errorMessage
- ViewAllOrdersPage.java

		- all web elements

	- ViewAllProductsPage.java
		- all web elements

	- Order
		- all web elements


What are the advantages of using Page Object Model Design Pattern?
#1- Re-usability
- We are creating ONE LOCATOR, ONE TIME, in ONE CLASS (in its own page class.)
- We keep re-using the same web Element

	#2- Easy to maintain:
		- Since we locate each web element only once, when we have issue, we will only go to ONE CLASS to fix it.

	#3- Easy to understand from scratch 
		- It will be very easy to understand/explain everyone in the team
		- We basically create java classes with the functionality or page name
















