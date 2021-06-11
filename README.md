# 🎯 About the project

### Project created to exercise my knowledge in REST API development.

## 🛠 Technologies used

### 🧱 Back end

- Java
- Spring Boot
- Jpa / Hibernate
- Maven
- PostgreSQL
- H2 Database


## 📋 Class Diagram

### (Building... 🛠)


## 📝 TaskLists

<details>
      <summary> User Tasks  ✅</summary>
      
- [X] Implement User classe
      
- [X] Implement DTO
      
- [X] Implement UserRepository
      
- [X] Implement UserMapper
      
- [X] Implement UserService
      <ul>
    <li> - [X] findAllByBirthDateOrderASC()</li>
    <li> - [X] findByName()</li>
    <li> - [X] insert()</li>
    <li> - [X] update()</li>
    <li> - [X] delete()</li>
    <li> - [X] findAllOrdersByUserId()</li>
    <li> - [X] findAllOrderByUserIdStatusPending()</li>
    <li> - [X] findAllOrderByUserIdStatusDelivered()</li>
      </ul>      
  
- [X] Implement UserController
- [X] Implement UserExceptions
- [X] Implement Validations in the UserService class
</details>

<details>
      <summary>  Deliveryman Tasks ✅</summary>
      
- [X] Implement Deliveryman classe
      
- [X] Implement DTO
      
- [X] Implement DeliverymanRepository
      
- [X] Implement DeliverymanMapper
      
- [X] Implement DeliverymanService
      <ul>
    <li> - [X] findAllOrderByNameASC()</li>
    <li> - [X] findByEmail()</li>
    <li> - [X] insert()</li>
    <li> - [X] update()</li>
    <li> - [X] delete()</li>
     
- [X] Implement DeliverymanController
- [X] Implement DeliverymanExceptions
- [X] Implement Validations in the DeliverymanService class
</details>

<details>
      <summary>  Order ✅ </summary>
      
- [X] Implement OrderStatus Enumeration     
     
- [X] Implement Order classe
      
- [X] Implement DTO
      
- [X] Implement OrderRepository
      
- [X] Implement OrderMapper
      
- [X] Implement OrderService
      <ul>
    <li> - [X] findAllOrdersByInstantASC()</li>
    <li> - [X] findAllOrdersByStatusPENDINGOrderByMomentASC()</li>
    <li> - [X] findAllOrdersByStatusDELIVEREDOrderByMomentASC()</li>
    <li> - [X] findById()</li>
    <li> - [X] insert()</li>
    <li> - [X] setDelivered() </li>
    <li> - [ building... 🔨 ] pagedSearch() </li>       
      </ul>
- [X] Implement OrderController
- [X] Implement OrderExceptions
- [X] Implement Validations in the OrderService class
 
</details>

<details>
      <summary> Relation between classes ⏳ </summary>
     
- [ ] Implement relation between ORDER-USER-DELIVERYMAN


 
</details>






# 📌 Project Endpoints


### User 

| HTTP VERB 	|       ENPOINT       	| OBJECTIVE                     	|
|-----------	|:-------------------:	|-------------------------------	|
| GET       	| /users              	| List all users by birth order 	|
| GET       	| /users/{name}/found 	| List user by name             	|
| GET       	| /users/{id}/orders 	| List all orders of the user id    |
| GET       	| /users/{id}/orders/status/pending 	| List all pending orders of the user id            	|
| GET       	| /users/{id}/orders/status/delivered  	|  List all delivered orders of the user id          	|
| POST      	| /user               	| Insert a user                 	|
| PUT       	| /user/updated       	| Update a user                 	|
| DELETE    	| /user/{id}/removed  	| Delete a user by id           	|



### Deliveryman 

| HTTP VERB 	|       ENPOINT       	| OBJECTIVE                     	|
|-----------	|:-------------------:	|-------------------------------	|
| GET       	| /deliverymans              	| List all deliverymans by name order 	|
| GET       	| /deliverymans/{email}/found 	| List  deliverymans by  email              	|
| POST      	| /deliverymans            	| Insert a Deliveryman                	|
| PUT       	|/deliverymans/updated      	|  Update a deliveryman                  	|
| DELETE    	| /deliverymans/{id}/removed  	| Delete a deliveryman by id           	|


### Order

| HTTP VERB 	|       ENPOINT      	| OBJECTIVE                 	|
|-----------	|:------------------:	|---------------------------	|
| GET       	| /orders            	| List all orders by moment 	|
| GET       	| /orders/pending    	| List all orders pending   	|
| GET       	| /orders/delivered  	| List all orders delivered 	|
| GET       	| /orders/{id}/found 	| List order by id          	|
| POST      	| /orders            	| Insert a order            	|
| PUT      	| /orders/set/{id}/delivered            	| Update a order status to delivered             	|


