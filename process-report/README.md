# Process Reports (Report Microservice)

Gets message from Start-Report service and creates a report. Once report is created, the status of the job assigned to this report is updated to "done".

# Kafka Configuration

* Make sure it has the correct group id
* If creating a new topic, ensure auto.create.topics.enable=true in C:\Program Files (x86)\FENICS\Pro3.1\fenics-enterprise\services\kafka\config\server.config

# Future Use

* Report Library has models that are used in Start-Report and Process-Report
* If updated in one place, it can be updated in all locations
* This is not used in this service

```
cd existing_repo
git remote add origin https://gitlabue.cad.local/kace-fxo/modernization-demos-and-pocs/reportservice.git
git branch -M main
git push -uf origin main
```