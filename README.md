## HotelRatingMicroserviceBackend
![MicroserviceArc](https://github.com/rohan9521/HotelRatingMicroserviceBackend/assets/43091846/12cefe0f-0a18-4932-8c3f-874669949266)



### Services
 * USER-Service
   * This service is used to manage CRUD operations for user.
   * It communicates with RATING-Service and HOTEL-Service using Feign Client and restTemplate.
   * Since one of the service or both the services can be down at any point of time, this service has fault tolerance.
   * Fault Tolerance is implemented using resilience4j.
 * RATING-Service
   * This service manages CRUD operations for Ratings of a hotel.
   * MongoDb is used for storage.
 * HOTEL-Service
   * This service manages CRUD operations for hotels.
   * MongoDb is used for storage.
 * API-GATEWAY
   * All the client request goes to the respective service through this gateway.
   * It uses patterns for identifying the requests and then routes to respective service.
   *    - id: USER-Service
          uri: lb://USER-Service
          predicates:
            - Path=/users/**
        - id: HOTEL-Service
          uri: lb://HOTEL-Service
          predicates:
            - Path=/hotels/**,/staff/**
        - id: RATING-Service
          uri: lb://RATING-Service
          predicates:
            - Path=/ratings/**
        - id: JWT-Service
          uri: lb://JWT-Service
          predicates:
            - Path=/auth/**
 * Authorization-Service-
   * It uses Json Web Token for authorization.
   * Internally uses USER-Service for checking if user exists or not.
   * Issues a token to tbe user.
   * Also Validates the token provided by the user. 
 * CONFIG-Service -
 * 
 * SERVICE-Registry -
   * It acts as a server where all the services gets registered to as client.
   * Its created using Eureka server.
   * All other services are Eureka client.
    ![ServiceRegistry](https://github.com/rohan9521/HotelRatingMicroserviceBackend/assets/43091846/044410d5-64b6-4a74-8aea-4b8b3d37f774)

### Feign-Client and Rest Template
 * Both were used for communication between the services. 
### Resilience4j
 * Resilience4j was used for fault tolerance.


