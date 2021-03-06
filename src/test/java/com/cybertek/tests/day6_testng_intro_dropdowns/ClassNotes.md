MAY 23RD, SUNDAY

#1- REVIEW
#2- PRACTICES
#3- TESTNG
#4- DROPDOWNS

------------------------------------------------------------------------------------

- XPATH:
    - What is xpath?
    - Xpath is one of the 8 locators in Selenium
    - Xpath allows us to create custom locators using any given attribute and value.
    - Xpath can move from parent to child, and child to parent.


	- How do we move from parent to DIRECT child?
	- To move from parent to direct child we use "/" at the end of the locator.

	Syntax: //tagName[@attribute='value']/childTag

	- How do we move from child to parent?
	- To move from child to direct parent we use "/.." at the end of the locator.

	Syntax: //tagName[@attribute='value']/..

	- How do we move from parent to ANY CHILD?
	- To move from parent to ANY child we use "//" at the end of the locator.

	Syntax: //tagName[@attribute='value']//anyChildTag --> This will jump to any given child tag under the already located web element

P.I.Q: How many different types of XPATH are there and what are the differences?
- 2 types of xpath locators.

	#1- Absolute xpath:
		- Starts with "/"
		- It means it starts from the root element "html"
		- We have to move from parent to child until we reach desired web element
		- Therefore it is LONG and not dependable.
		- If one of the web elements used in this locator is removed, or any other web element is added, this locator will break.
		- Therefore absolute xpath is not suggested to use.

		syntax: /html/body/div/div/a


	#2- Relative xpath:
		- Starts with "//"
		- "//" means start from anywhere in the html.
				- means jump to the point you will be given
		- Relative xpath is a lot more reliable compared to absolute xpath.
		- For relative xpath to break, the web element (or the attribute value) we locate directly has to change. 


		//tagName[@attribute='value']


	Common xpath locators:

	#1- //tagName[@attribute='value']
	#2- //tagName[.='text']
		//tagName[text()='text']

	#3- //tagName[contains(@attribute,'value')]
	#4- //tagName[starts-with(@attribute,'value')]
	#5- //tagName[ends-with(@attribute,'value')]

P.I.Q:
- How do you handle dynamic web elements?
- How do you handle web elements that has dynamic attribute value?


	#1-> We use methods provided by xpath locator. 
		- contains
		- starts-with
		- ends-with
	#2-> Find a static parent or child web element and move from that to desired web element.

	<div id="sunny983745983475"> 

		<a href="https://www.google.com"> GOOGLE </a>

	</div>

	#3- //div[contains(@id,'sunny')]
	#4- //div[starts-with(@id,'sunny')]

	id="983745983475sunny"

	#5- //div[ends-with(@id,'sunny')]


--> if you find dynamic attribute value, you can copy the value to notepad.
- refresh the page, copy again.
- compare to find static parts to be used.

			0ahUKEw iauP6g hODwAh WGX80KHYRaAUA Q39UDCAY
			0ahUKEw jNl5Ct hODwAh XXWc0KHetmDq8 Q39UDCAY


--> Using index numbers with xpath locator.


	<div id="sunny983745983475"> 

		<a href="https://www.google.com"> GOOGLE </a>
		<a href="https://www.google.com"> GOOGLE </a>
		<a href="https://www.google.com"> GOOGLE </a>

	</div>


	--> //a[text()='GOOGLE'] -> This will return me 1/3

	(//a[text()='GOOGLE'])[1]
	(//a[text()='GOOGLE'])[2]
	(//a[text()='GOOGLE'])[3]

--> We surround the locator with paranthesis and pass the index number of the web element we are trying to locate.
- If web elements are siblings to each other, we don't have to use paranthesis.

		//a[text()='GOOGLE'][1]
		//a[text()='GOOGLE'][2]

	- If they are not in the same level (not siblings) we have to use.

		(//a[text()='GOOGLE'])[1]
		(//a[text()='GOOGLE'])[2]

--> in xpath index start from 1.

--> How do we verify if a checkbox or radio button is selected or not?
- checkbox.isSelected();
- This method will return "true" if given the checkbox is selected.
- Will return "false" if given checkbox/radiobutton is NOT SELECTED.


------------------------------------------------------------------

- implicitlyWait();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    - implicitlyWait is one of the waits coming from selenium library.

    - What is the condition implicitlyWait is looking for?
    - implicitlyWait is triggered every time we use findElement method.
    - if driver.findElement method is not able to find a web element, it will wait UP TO given duration.
        - if web element is found before time is up, it will continue execution.
        - if not, driver will throw NoSuchElementException.

    - By default implicitlyWait value is set to 0.
    - We have to change it to 5-10-15 whatever seconds we want to change.


-----------------------------------------------------------------------------------

TESTNG:
- What is TestNG?
- TestNG is a UNIT TESTING FRAMEWORK(TOOL).

Annotations:
- Allows us to give/change existing behavior of a method.


#1- @Test

	- If we create a java method, and use @Test annotation on top of it, this method will become an executable TestNG test.


#2- @BeforeMethod:

	- Whichever method is applied with @BeforeMethod, will run once before EACH TEST.
	- It means, it will run as many times as the tests we have.
	- Usually good for creating setups for browser and driver.

#3- @AfterMethod:

	- Whichever method is applied with @AfterMethod, will run once AFTER EACH TEST.
	- It means, it will run as many times as the tests we have.
	- Usually good for teardown stuff: such as closing browser. 

#4- @BeforeClass:
	- Will run ONCE before EVERYTHING else.
	- It will run only one time when the code is executed.

#5- @AfterClass:
	- Will run ONCE after EVERYTHING else.
	- It will run only one time when the code is executed.


--> Except for @Test annotation, everything is ran by the annotations. Therefore, it is not important in what order we write them.


--> For @Test (s):
- By default they are ran by alphabetical order.
- We can create priority in between each test, if we want to make tests run in specific order.
- Each test is INDEPENDENT FROM EACH OTHER, unless we create dependency.
- It means, if one fails, the other will be still executed.

- priority
    - the smaller the priority number, the earlier the test will be running.


Assertions:
- Assertions in TestNG are static methods.
- We can pass boolean values, or multiple arguments depending on the type of assertion we are using.

	- On the line the assertion fails, it will stop execution in that test.
	- For this reason, if you have to create multiple assertions in one test, you might want to consider creating a different @Test for the second assertion


- assertEquals(arg1, arg2);
    - This assertion accepts 2 arguments of the same type.
    - If arg1 is not equal to arg2, assertion will fail.

- assertTrue(boolean);
    - This assertion accepts 1 boolean argument.
    - If boolean returns "false" assertion will fail.


--------------------------------------------------------------------

HOW TO HANDLE DROPDOWNS USING SELENIUM?
- There are 2 types of dropdowns.

	#1- HTML DROPDOWNS (non-select) :
		- If a dropdown is created using anything other than <select> tag, it is called HTML dropdown.
		- We handle just as any other web element.
		- We locate. We click.

	#2- SELECT DROPDOWNS
		- Select dropdowns are created using <select> tags, and the options are created using <option> tag


	- How to handle Select dropdowns?
		#1- We locate the select dropdown
		#2- We create an object of "Select" (from Selenium library)
		#3- We pass the already located web element into the constructor of Select object.
		#4- Using the object, we will be able to reach the methods coming from this.


	syntax: 

		WebElement something = driver.findElement(By.LOCATOR);

		Select select = new Select(something);

- what is default selected
- after selection, is it actually selected
- how many options in the dropdown

--> .getFirstSelectedOption();
--> This method will return the currently selected option from the dropdown.
--> Return type: WebElement

	select.getFirstSelectedOption();

--> .getOptions();
--> Returns all of the options in the dropdown.
--> Return type : List<WebElement>


--> .getAllSelectedOption();
--> Returns all of the selected option as a List of WebElement.


HOW TO SELECT FROM A DROPDOWN:
-> There are 3 ways to select.

	#1- ByText
		-> This method accepts the text of the option as a String, and select.

		syntax: select.selectByVisibleText("the text of the option");

	#2- ByValue
		
		-> This method accepts the value of the attribute "value" as a String.
		-> It will select the given option.

		syntax: select.selectByValue("1");

	#3- ByIndex
		-> This method accepts the index number of the option as int
		-> Indexes start from 0

		syntax: select.selectByIndex(0);






















