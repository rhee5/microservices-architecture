# Microservices Architecture

Demonstrate key concepts for a microservice architecture that can be accessed through the web, which was my main project in my 2024 Summer Internship. Most of the code is written in Java. I used Gradle to build the project and Spring Boot to create these applications. I used Apache Kafka as the messaging service.

1. Heap Monitor Library

  * This project can be added as a dependency to any application.
  * It runs in the background at a specified frequency to check whether heap usage has hit a certain specified threshold.
  * If the threshold is reached, it will trigger a configurable alert method. (The default alert method is just a log, but it can be modified to send an email or show a pop-up message.)


2. Process C++ File

  * This project was to wrap C++ code in a java project that can be triggered through a REST endpoint or through a messaging service.
  * Requires C++ executable file to be in the project file.


3. REST API Demo

  * REST API to access and manipulate database (GET, POST, DELETE calls)
  * Added an in-memory cache for fast access to the data on repeated calls
  * Implemented Swagger UI to clearly describe the structure of the APIs

4. Asynchronous Calls Management

  * For a time consuming report, instead of keeping an open http connection and have the user waiting at a loading screen, it is better to have the processes running in the background.
  * The initial request for the report is sent to the start report service through REST endpoint. This service creates and returns a job with a status of "pending". It also sends a message to the process report service to start the required report
  * Once the report is completed, the process report service will update the job status to "done".
  * The user can poll every minute in the background to check if the job is done, after which the start-report service will return the completed report.
  * Implemnted Swagger UI to clearly describe the structure of the APIs
  * Added an endpoint to monitor health and metrics using Spring Boot Actuator


I also wrote a script to manually start and stop these microservices as a single call instead of individually having to go into each folder.
