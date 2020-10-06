# A Spring Boot application using Spring-Data-JPA

It demonstrates the below.
 - How to use JPA in Spring Boot


##Sample Requests:

###createOrderByID
curl --location --request PUT 'http://localhost:8080/v1/main/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "deliveryLocation": "india",
    "totalPrice": 1000,
    "items": [
        {"quantity": 5},
        {"quantity": 10}
    ]
}'


###getOrderByTotalPrice
curl --location --request GET 'http://localhost:8080/v1/main/1000' \
--header 'Content-Type: application/json' \
--data-raw '{
    "deliveryLocation": "india",
    "totalPrice": 1000,
    "items": [
        {"quantity": 5},
        {"quantity": 10}
    ]
}'


###deleteOrderByID
curl --location --request DELETE 'http://localhost:8080/v1/main/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "deliveryLocation": "india",
    "totalPrice": 1000,
    "items": [
        {"quantity": 5},
        {"quantity": 10}
    ]
}'

