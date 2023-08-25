# Emils_Riekstins_TDL_SS_Final_Task

Project contains 5 test cases for testing [globalsqa demo site](globalsqa.com/demo-site/) and [globalsqa auto complete](globalsqa.com/demo-site/auto-complete/) page features <br>
Tests are performed using Java and selenium with Extent Framework reporter <br>
Tests are created using page object model (PMO) with two types: smoke and regression <br>

Test class is located in src/test/java/FinalTask1.java <br>

**!! uBlock-Origin should be located in C:/extensions/ !!** <br>

# Maven commands + explanation:
* Running one specific test class <br>
_mvn test -Dtest=com.example.MyTest_ <br>
Runs all the tests within MyTest class (com.example is the path to the calss)

* Running one specific test in class <br>
_mvn test -Dtest=com.example.MyTest#testSomething_ <br>
Runs testSomething test in MyTest class 

* Running un all Regression tests <br>
_mvn test -Pregression-tests_ <br>
Assuming that all tests are located in src/test/java/ folder it will run all tests that have been specified as regression in testng.xml file

* How to exclude tests from running
1) Using Surefire Plugin Excludes. It is used in Maven for running tests and can be configured to exclude certain test classes or methods using '-Dtest' <br>
For example: mvn test -Dtest=!com.example.ExcludedTest <br>

2) Using Surefire Plugin Excludes in pob. As the previous example Surefire can be used to do exclusions directly in the project's 'pom.xml' file by specifying the excluded classes within the configuration <br>
For example:
```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>**/ExcludedTest.java</exclude>
                    <exclude>**/MyTest.java#excludedMethod</exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
```

3) Using TestNG groups. If testNG is used as the testing framework, groups can be used to categorise tests and excluded specific groups (for example 'regression') during test execution <br>
Example: <br>
First specify the group before the class: <br>
```
@Test(groups = "regression")
public void MyTest() {
    // Test logic here
}
```
And then exclude them in the testng.xml configuration file: <br>
```
<suite name="MyTestSuite">
    <test name="RegressionTests">
        <groups>
            <run>
                <exclude name="regression"/>
            </run>
        </groups>
        <classes>
            <class name="com.example.MyTest"/>
        </classes>
    </test>
</suite>
```

# Tests
* Test 1 <br>
Tests opening dialog box page and creating new user with name: Emils Riekstins, email: emils@riekstins .com and password: mypassword and checks if the new user account has been added to the list

* Test 2 <br>
Tests opening of tabs page and section 2 within it and checks if the section has been opened

* Test 3 <br>
Tests opening of progress bar page and random progress bar within it and selects random color and random value

* Test 4 <br>
Tests opening dialog box page and message box tab within it. Tests message box tab closing

* Test 5 <br>
Tests auto complete page search field and checks if 'anders andersson' can be selected if 'and' is input
