# Process C++ Executable
Wrap C++ executable file in Java microservice to access via REST API endpoint or Kafka message.
Examples of both in the controller.

# To Note
1. Make sure the executable file is in main/resources
2. Make sure Kafka configuration group-id is accurate
3. Ensure auto.create.topics.enable=true in C:\Program Files (x86)\FENICS\Pro3.1\fenics-enterprise\services\kafka\config\server.config if creating a new topic

```
cd existing_repo
git remote add origin https://gitlabue.cad.local/kace-fxo/modernization-demos-and-pocs/reportservice.git
git branch -M main
git push -uf origin main
```