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
      </ul>
- [X] Implement DeliverymanController
- [X] Implement DeliverymanExceptions
- [X] Implement Validations in the DeliverymanService class
</details>

<details>
      <summary>  Order ⏳ </summary>
      
- [ ] Implement OrderStatus Enumeration     
     
- [ ] Implement Order classe
      
- [ ] Implement DTO
      
- [ ] Implement OrderRepository
      
- [ ] Implement OrderMapper
      
- [ ] Implement OrderService
      <ul>
    <li> - [ ] findAllOrdersByInstantASC()</li>
    <li> - [ ] findAllOrdersByStatusPENDING()</li>
    <li> - [ ] findAllOrdersByStatusDELIVERED()</li>
    <li> - [ ] findById()</li>
    <li> - [ ] insert()</li>
    <li> - [ building... 🔨 ] pagedSearch() </li>       
      </ul>
- [ ] Implement OrderController
- [ ] Implement OrderExceptions
- [ ] Implement Validations in the OrderService class
 
</details>

<details>
      <summary> Relation between classes ↔️ </summary>
     
- [ ] Implement relation between ORDER-USER-DELIVERYMAN


 
</details>






# 📌 Project Endpoints


### User 

| HTTP VERB 	|       ENPOINT       	| OBJECTIVE                     	|
|-----------	|:-------------------:	|-------------------------------	|
| GET       	| /users              	| List all users by birth order 	|
| GET       	| /users/{name}/found 	| List user by name             	|
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


