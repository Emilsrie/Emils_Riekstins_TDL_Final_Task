# Emils_Riekstins_TDL_SS_Final_Task

Project contains 5 test cases for testing globalsqa.com/demo-site/ and globalsqa.com/demo-site/auto-complete/ page features.
Tests are performed using Java and selenium with Extent Framework reporter.
Tests are created using page object model (PMO) with two types: smoke and regression.

Test class is located in src/test/java/FinalTask1

!!uBlock-Origin should be located in C:/extensions/!!

#Maven commands + explanation:
* Running one specific test class
mvn test -Dtest=com.example.MyTest 
Runs all the tests within MyTest class (com.example is the path to the calss)

* Running one specific test in class
mvn test -Dtest=com.example.MyTest#testSomething
Runs testSomething test in MyTest class

* Running un all Regression tests
mvn test -Pregression-tests
Assuming that all tests are located in src/test/java/ folder it will run all tests that have been specified as regression in testng.xml file

* How to exclude tests from running
* 

# Tests
### Test 1
Tests opening dialog box page and creating new user with name: Emils Riekstins, email: emils@riekstins .com and password: mypassword and checks if the new user account has been added to the list

### Test 2
Tests opening of tabs page and section 2 within it and checks if the section has been opened

### Test 3
Tests opening of progress bar page and random progress bar within it and selects random color and random value

### Test 4
Tests opening dialog box page and message box tab within it. Tests message box tab closing

### Test 5
Tests auto complete page search field and checks if 'anders andersson' can be selected if 'and' is input
