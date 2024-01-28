

# Gateway-Client-Store

## Diagram

![Diagrama sem nome drawio](https://github.com/Renanmartim/App_Gateway_Store/assets/117313515/782652a5-4bf3-4429-b169-acba3184cf1f)

## Overview

This project demonstrates a simple microservices architecture with a Gateway, Client, and Store components, each implemented as separate Spring Boot applications. The Gateway serves as a central entry point, routing requests to the appropriate services. The Client and Store services contain controllers that handle authorization based on an internal ID.

## Components

### 1. Client Service

#### ClientController

- **Endpoint:** `/client`
  
  - **GET `/`**
    - Retrieves information from the Client service.
    - Requires the `Internal-ID` header for authorization.
  
  - **POST `/addbalance`**
    - Adds balance to the Client service.
    - Requires the `Internal-ID` header for authorization and BalanceRequestDto.
   
  - **POST `/subtractbalance`**
    - Subtracts the purchase amount from the customer's wallet.
    - Requires the `Internal-ID` header for authorization and BalanceRequestDto.
   
    - **POST `/createUser`**
    - Create user.
    - Requires the `Internal-ID` header for authorization and ClientEntity.

    - **POST `/clientpurshase`**
    - Make a request to the Store to purchase the product.
    - Requires the `Internal-ID` header for authorization and ClientNotBalanceDto.


### 2. Gateway Service

#### ConfigGateway

- **Routes:**
  
  - **Route: `store`**
    - Path: `/store`
    - Filters: Add `Internal-ID` header with the secret pass.
    - Forward requests to `http://localhost:8082/`.

  - **Route: `client`**
    - Path: `/client`
    - Filters: Add `Internal-ID` header with the secret pass.
    - Forward requests to `http://localhost:8081/`.

  - **Route: `addbalance`**
    - Path: `/client/addbalance`
    - Forward requests to `http://localhost:8081/`.

  - **Route: `addProduct`**
    - Path: `/store/addProduct`
    - Forward requests to `http://localhost:8082/`.
   
    - **Route: `store`**
    - Path: `/store`
    - Forward requests to `http://localhost:8082/`.
   
      ...

### 3. Store Service

#### StoreController

- **Endpoint:** `/store`

  - **GET `/`**
    - Retrieves information from the Store service.
    - Requires the `Internal-ID` header for authorization.

  - **GET `/addProduct`**
    - Adds a product to the Store service.
    - Requires the `Internal-ID` header for authorization and StoreEntity object.

    - **GET `/getAll`**
    - Returns all products from the store.
    - Requires the `Internal-ID` header for authorization.
   
      - **POST `/clientBuy`**
    - Makes the purchase, updates the value in the customer's inventory and wallet using /client/subtractbalance using the correct route in the gateway.
    - Requires the `Internal-ID` header for authorization and ClientBuyDto.

## Configuration

- All services use the `secret-pass` value from the configuration for authorization.

## How to Run

1. Clone the repository.
2. Build each service using Maven.
3. Run the services in the following order:
   - Run the Store service on `http://localhost:8082/`.
   - Run the Client service on `http://localhost:8081/`.
   - Run the Gateway service on `http://localhost:8086/`.

Make sure to configure the `secret-pass` in the configuration files for each service.

## Notes

- This is a simplified example and does not include proper security measures for production use.
- Ensure that the configuration values match across services for proper communication.

Feel free to extend or modify the project according to your requirements!

</body>
</html>
