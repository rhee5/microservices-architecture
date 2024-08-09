# REST API Demo
Get, Post, Delete methods for Holidays, Conventions, Prefs tables in Daylights database

# API Documentation

* Uses the swagger config class
  * http://localhost:8080/swagger-ui/
  * Can specify descriptions in swagger UI with
    * @ApiOperation(value = "description next to the name", notes = "longer description for when method is clicked on")


# Caching

* Conventions is an example of spring boot cache
* For Redis cache, see commit: 4eb3f2e62886362bf981d4ac1f10bdf500011e6d

```
cd existing_repo
git remote add origin https://gitlabue.cad.local/kace-fxo/modernization-demos-and-pocs/kafka-consumer.git
git branch -M main
git push -uf origin main
```