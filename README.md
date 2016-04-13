# Examples of Data Repositories using Spring Data JPA, DeltaSpike Data and QueryDSL.

[![Build Status](https://travis-ci.org/corneil/data-repositories.png?branch=master)](https://travis-ci.org/corneil/data-repositories)

This project was derived from [https://github.com/mstahv/jpa-helper-libraries](https://github.com/mstahv/jpa-helper-libraries)

Using Data Repositories provided an architecturally sound way of implementing a data layer.

This example project introduces the audience to, [Spring Data JPA](http://projects.spring.io/spring-data-jpa), its plain CDI cousin [DeltaSpike Data](https://deltaspike.apache.org/documentation/data.html) and [QueryDSL](http://www.querydsl.com). 
The example app contains three EJB different implementations for simple phonebook CRUD and shows how the tools can help to implement them.

The project has separate modules for [JPA Entities](data-entities) and implementations using [Spring Data JPA](spring-data), [DeltaSpike Data](delta-spike-data) and [QueryDSL](querydsl-data).
Unit Tests have been added to each of the modules.

## Importing into IDE
* Create a new workspace.
* Open Shell and change directory to the workspace folder.
* Execute
```
git clone https://github.com/Jozi-JUG/data-repositories.git
```
### In Eclipse
* In Eclipse Select File -> Import -> Gradle
* Select the workspace folder/data-repositories
* You should see the project and a list of sub projects.
* Click Finish and wait a while because Gradle will have to resolve a lot of dependencies.

If you want to cut down on the wait time in Eclipse you can build the project on the commandline first.  
```
gradlew assemble
```
### Building Maven project in Eclipse
* Select data-repositories project
* Right-Click and Select Run As -> Gradle Build...
* Enter 'build' into Tasks
* Click Run

The Gradle build will execute the unit tests as well.
In order to execute the unit tests in Eclipse locate the Test classes under src/test/java packages.  
Select the test and right-click and select Run As -> JUnit Test.

### In Intellij IDEA

[<img src="https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif">/<img>](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=corneil%2eduplessis%40gmail%2ecom&lc=ZA&item_name=Corneil%20du%20Plessis&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted)