## Friday Solution
### Docker Image Pull Command
```shell
docker pull prahladrao/tasks:latest
docker run -p 8080:8080 prahladrao/tasks:latest 
```
### Run Application
For running the application locally:

```shell
mvn clean install
docker-compose build
docker-compose up -d
```
--------------
### Explore API
For exploring the API, please visit swagger-ui link

* [Swagger UI](http://localhost:7800/friday-challenge/openapi/swagger-ui.html)
* [Openapi JSON](http://localhost:7800/friday-challenge/openapi/v3/api-docs)

--------------

### Testing app via Postman
* Refer [PostManCollection](https://github.com/friday/friday.postman_collection.json)
--------------

### Endpoint Details
### parseAddress: GET
```
http://localhost:7800/friday-challenge/v1/parseAddress
```
Request
```
{
    "address": "200 Broadway Av"
}
```
Response
```
{
    "street": "Broadway Av",
    "housenumber": "200"
}
```
### health: GET
```
http://localhost:7800/friday-challenge/actuator/health
```
### prometheus: GET
```
http://localhost:7800/friday-challenge/actuator/prometheus
```