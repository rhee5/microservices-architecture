# Start Reports (Job Microservice)

Use Report Controller post method to request a report
Service will return a job with a status of "pending"
Will send message to process-report microservice to begin the report calculations (just a delay)
Can poll for that job id until the job has a status of "done", which will redirect to the newly created report object


# API Documentation

* Uses the swagger config class
  * http://localhost:8081/swagger-ui/
  * Can specify descriptions in swagger UI with
    * @ApiOperation(value = "description next to the name", notes = "longer description for when method is clicked on")
* Can get more information about the microservice with http://localhost:8081/actuator/health
  * Can also provide information on metrics, beans, env, threaddump, loggers (replace health)


# Start / Stop Services Together

* The Makefile starts the holiday-demo, start-report, and process-report microservice.
  * Might need to update / install wsl or install Make via Chocolatey
* Start: make start
  * Runs the processes in the background and creates a log file for each of the microservices to log the information
* Stop: make stop


# Kafka Configuration

* Make sure it has the correct group id 
* If creating a new topic, ensure auto.create.topics.enable=true in C:\Program Files (x86)\FENICS\Pro3.1\fenics-enterprise\services\kafka\config\server.config


```
cd existing_repo
git remote add origin https://gitlabue.cad.local/kace-fxo/modernization-demos-and-pocs/kafka-consumer.git
git branch -M main
git push -uf origin main
```