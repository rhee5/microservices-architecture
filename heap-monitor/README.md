# heap-monitor

Monitor heap space using a Spring Boot application. 

# Variables to Note:

* heap-monitor.memory.threshold: only logs alerts when heap memory surpasses the specified threshold (default value 80%)
* heap-monitor.frequency: rate at which this service runs in milliseconds (default value 36000 or 10 minutes)

Can be changed in an application.properties / application.yml file

# Import to Project

* download heap-monitor jar and add it to the project as a physical dependency
* in build.gradle under dependencies, add: api(files("path to heap-monitor jar"))
* also requires spring-boot dependencies

# Add to Project

* in the main method of the project, add following annotations
  * @Import(HeapMonitoringService.class, AlertRunnable.class)
  * @EnableScheduling
* if it is not already a spring boot application, add:
  * @SprintBootApplication
  * in the main method, add:
    * SpringApplication.run(CurrentClassName.class.java, args)
* see com.fenics.monitor.example.HeapMonitoringServiceTest for an example
* also can refer to AB2B Service for configuration and adding dependency

# Configure Alert Method

When heap space usage passes the set memory threshold, this service will log a warning alert. To change this, add a configuration file to your project.

* Make sure to annotate the class with @Configuration
* Make sure to annotate the overridden run method with @Bean and @Primary
* See com.fenics.monitor.example.HeapMonitorConfig for an example

```
cd existing_repo
git remote add origin https://gitlabue.cad.local/kace-fxo/libraries/heap-monitor.git
git branch -M main
git push -uf origin main
```