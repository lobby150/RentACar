# XTMTest
Application for renting a car (REST API)

Works on 127.0.0.1:8080

## Technologies
Project is created with:
 * Spring Boot version 2.3.1
 * PostgreSQL

## Car endpoints:
```
127.0.0.1:8080/car/get-all - get list of all cars
127.0.0.1:8080/car/{id} - get car by id
127.0.0.1:8080/car/add - add new car in JSON format {brand, model}
127.0.1.1:8000/car/delete/{id} - delete a car
```
## Client endpoints:
```
127.0.0.1:8080/client/get-all - get list of all clients
127.0.0.1:8080/client/{id} - get client by id
127.0.0.1:8080/client/add - add new car in JSON format {firstName, surname}
127.0.1.1:8000/client/delete/{id} - delete a car
```
## Renting endpoints:
```
127.0.0.1:8080/renting/get-all - get list of all current rentings
127.0.0.1:8080/renting/add - add new renting in JSON format {car, client} for example {"car": "1", "client": "1"}
127.0.0.1:8080/renting/{id} - get renting by id
127.0.0.1:8080/renting/delete/{id} - delete a renting (it means that a client is deciding to give away rent car)
```

## Setup
```
To run this project install Docker Engine and Docker Compose then:
$ cd rentcar/src/main/resources
$ sudo docker-compose up
```
