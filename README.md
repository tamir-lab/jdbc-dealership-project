# Car Dealership Project

## Description of the Project

This workshop project focuses on building a Java application that interacts with a relational database using JDBC. The program manages basic operations for a car dealership, including storing, retrieving, and updating vehicle information.

The project applies the concepts introduced in the JDBC module, including:

Establishing a connection to a database through a DataSource

Executing SQL queries using PreparedStatement

Reading data from ResultSets

Mapping database rows into Java objects

Implementing CRUD functionality (Create, Read, Update, Delete)

Handling exceptions and managing resources safely with try-with-resources

The application allows users to view vehicle inventory, search for vehicles by ID or other criteria, and perform updates as specified by the workshop requirements. The goal of this project is to provide hands-on experience working with Java and SQL together, reinforcing database access patterns and best practices.

## User Stories


- As a User I want to be able to search for a vehicle using a filter, so that I can quickly find the vehicle I’m looking for.
- As a user, I want to add a new vehicle to a dealership’s inventory so that the dealership’s available vehicles remain accurate and up to date.
- As a user, I want to create a sales or lease contract for a customer so that completed transactions are recorded and stored properly.
- As a user, I want to remove a vehicle from a dealership’s inventory so that sold or unavailable vehicles no longer appear in search results.

## Setup

Instructions on how to set up and run the project using IntelliJ IDEA.

### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'YourMainClassName.main()'' to start the application.

## Technologies Used

- Java 17.
- MySQL Workbench.

## Demo

![DemoGIF.gif](DemoGIF.gif)
Demo for "Search a vehicle" and "Add a vehicle" options.

## Future Work


- Report creation by csv files output.
- Filtering by multiple values.
- Contract creation by csv file output.

## Resources


- Pluralsight Workbooks
- [Potato Sensei](https://github.com/RayMaroun/yearup-fall-section-8-2025)

## Team Members

- Tamir Dmitriev, developer.

## Thanks

- Thank you to Potato Sensei
