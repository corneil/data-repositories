# Examples of Data Repositories using Spring Data JPA, DeltaSpike Data and QueryDSL.

This project was derived from [https://github.com/mstahv/jpa-helper-libraries](https://github.com/mstahv/jpa-helper-libraries)

Using Data Repositories provided an architecturally sound way of implementing a data layer.

This example project introduces the audience to, [Spring Data JPA](http://projects.spring.io/spring-data-jpa), its plain CDI cousin [DeltaSpike Data](https://deltaspike.apache.org/documentation/data.html) and [QueryDSL](http://www.querydsl.com). 
The example app contains three EJB different implementations for simple phonebook CRUD and shows how the tools can help to implement them.

The project has separate modules for [JPA Entities](data-entities) and implementations using [Spring Data JPA](spring-data), [DeltaSpike Data](delta-spike-data) and [QueryDSL](querydsl-data).
Unit Tests have been added to each of the modules.
The [Web layer](vaadin-web) is built using [vaadin](https://vaadin.com/).

To play around with the project, import it in to your favourite IDE and deploy to WildFly using *mvn --projects vaadin-web wildfly:run*.

 
