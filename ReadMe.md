
# Book Library

This book libarary contains four microservice including Eureka Service registry and Cloud API Gateway created using spring boot framework.

## Book service
This service provides three API endpoints to create book entry and retrieve the book information and runs at port 8081
The API Gateway running at port 9090 , as the service registred with API Gateway and Eureka server as client. This service can be access throught Gateway.
Below are the endpoints 

- POST http://localhost:9090/api/books
- GET http://localhost:9090/api/books/{bookId}
- GET http://localhost:9090/api/books
- POST http://localhost:8081/api/books/{bookid}}/issues

### Swagger
This service has swagger documentation and Swagger UI that can be access throuhgt the below URLs.
http://localhost:8081/v3/api-docs
http://localhost:8081/swagger-ui

## Subscription service
This microservice aslo registred in Eureka service registry and can be access throught the below endpoints
- GET http://localhost:9090/api/subscriptions 
retrieves all subscriptions
- GET http://localhost:9090/api/subscriptions?name=pal
Retrieves book subscription of a specific subscriper by name.
- Post http://localhost:9090/api/subscriptions
This endpoint creates new subscrption in database and it internelly invoking book serive api http://localhost:8081/api/books/B1212/issues through using Rest template.

### Sample screenshot of Swagger UI

![SwaggerUI image ](https://github.com/acp3012/java-book-library/blob/main/images/Book-service-swagger-ui.png)

![Model document](https://github.com/acp3012/java-book-library/blob/main/images/swagger-models-sample.png)

### Exceptions
Global Exception handling has been implemented in Both micro services.
NoTFoundException    http status code 400               
ResouceAlreadyExists return http status code 409 
And Model validation exceptions
![Not Found example](https://github.com/acp3012/java-book-library/blob/main/images/NoFoundException.png)

### Model validation
Model validation has been implemented 

![Error sample ](https://github.com/acp3012/java-book-library/blob/main/images/ModelValidation_Error.png)