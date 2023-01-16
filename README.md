# Servlets_JSP-Pages
Servlets and JSP pages

Description

This is a project for testing CRUD operations on a database using JDBC API.
Using DAO Layer with JDBC and Singleton

Requirements

JDK 1.8

Data Model

MySQL database named education with 5 tables: university, faculty, professor, student and subject.
These tables are represented accordingly in the project with the suitable model java classes.

Connecting to Database

Active local MySql connection is needed  (e.g. using mysql workbench).
The connection is done with the singleton desigh pattern, using the class SingletonConnection.java where the user, the password and the database url are provided.
A maven dependency is added in pom.xml: mysql-connector-java.

Data Access Object

The DAO pattern is used to perform CRUD operations on the database.
For each of the model classes there is a DAO interface
with the basic CRUD methods and a DAO implementation class for that interface.

Service Layer

The Service Layer is represented with service interface classes for each DAO interface class and its own implementing class.

Data Transfer Object Layer

In the DTO layer of the project, there is custom made DTO model classes for each model entity class
and the DTO objects are used for interaction with the database.

Servlets

A maven dependency is added in pom.xml: javax.servlet-api.
web.xml configuration file is added in WEB-INF folder.
There are servlets java classes for each model class and servlets for error handling.
The following maven dependencies are also added: gson, jstl, junit.

Starting the project

1. Clone the repository in a local directory.
2. Open the chosen local directory as an intelliJ project.
3. Wait till the indexing of the files from intellij finish.
4. There should be active local mysql connection of an identical database.
5. Provide the database user, password and url into the SingletonConnection.java class.
6. A tomcat server is used for running the servlets, locally.
7. The project can be run via the model servlets and the app is running via the jsp files in the browser.

Business Logic

The project is a user friendly graphic interface which allows visual management of the database education.
The GUI is presented with bootstrap and JSP pages.