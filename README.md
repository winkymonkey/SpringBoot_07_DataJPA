# A Spring Boot application using Spring-Data-JPA

It demonstrates the below.
 - How to use JPA in Spring Boot



## Sample Requests:

### createOrderByID
curl --location --request PUT 'http://localhost:8080/v1/main/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "deliveryLocation": "India",
    "totalPrice": 1000,
    "items": [
        {"quantity": 5},
        {"quantity": 10}
    ]
}'
curl --location --request PUT 'http://localhost:8080/v1/main/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "deliveryLocation": "Spain",
    "totalPrice": 1000,
    "items": [
        {"quantity": 55},
        {"quantity": 11}
    ]
}'
curl --location --request PUT 'http://localhost:8080/v1/main/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "deliveryLocation": "India",
    "totalPrice": 6000,
    "items": [
        {"quantity": 99},
        {"quantity": 100}
    ]
}'


### getOrderByOrderId
curl --location --request GET 'http://localhost:8080/v1/main/byId/1' \
--data-raw ''


### getOrderByTotalPrice
curl --location --request GET 'http://localhost:8080/v1/main/byTotalPrice/1000' \
--data-raw ''


### getOrderByDeliveryLocation
curl --location --request GET 'http://localhost:8080/v1/main/byDeliveryLocation/India' \
--data-raw ''


### deleteOrderByID
curl --location --request DELETE 'http://localhost:8080/v1/main/1' \
--data-raw ''

