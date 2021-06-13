# 🎯 About the project

#### Project created to exercise my knowledge in REST API development.

## 🛵🍕 Bruno Lanches is a personal project for a delivery-style food store.

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
    <li> - [X] findAllOrdersByDeliverymaIdDelivered()</li>
    <li> - [X] findAllOrdersByDeliverymanIdPending()</li>
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
      <summary> Relation between classes ✅ </summary>
     <ul>
           <li>- [X] Implement relation between ORDER-USER-DELIVERYMAN</li>
      </ul>
</details>
      
      
<details>
      <summary>  Category task 11/13 =  ✅ 2  = ⏳ </summary>
      
      
      
 - [X] Implement Category classe
      
- [X] Implement Seed Category SQL
      
- [X] Implement DTO
      
- [X] Implement CategoryRepository
      
- [X] Implement CategoryService
      <ul>
    <li> - [X] findAllCategories()</li> 
         <li> - [X] findCategoryById()</li>
            <li> - [X] findCategortByName()</li>
            <li> - [ ] findAllProductsByCategoryId() </li>
             <li> - [ ] findAllProductsByCategoryName() </li>
      </ul>
- [X] Implement CategoryController
- [X] Implement CategoryExceptions
- [X] Implement Validations in the CategoryService class
 
</details>
      
 <details>
      <summary> Implement class Product ⏳  </summary>
     <ul>
           <li>- 🔨  Building ... </li>
      </ul>
</details>
      
<details>
      <summary> Relation between Product and Category ⏳ </summary>
     <ul>
           <li>- [ ] Implement relation between Product and Category </li>
      </ul>
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
| POST      	| /users               	| Insert a user                 	|
| PUT       	| /users/updated       	| Update a user                 	|
| DELETE    	| /users/{id}/removed  	| Delete a user by id           	|



### Deliveryman 

| HTTP VERB 	|       ENPOINT       	| OBJECTIVE                     	|
|-----------	|:-------------------:	|-------------------------------	|
| GET       	| /deliverymans              	| List all deliverymans by name order 	|
| GET       	| /deliverymans/{email}/found 	| List  deliverymans by  email              	|
| GET       	| /deliverymans/orders/{id}/delivered	| Lists all orders delivered from the id referring to the deliveryman             	|
| GET       	|/deliverymans/orders/{id}/pending	| Lists all orders pending from the id referring to the deliveryman             	|
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
      
      

### Category
      
| HTTP VERB 	|       ENPOINT      	| OBJECTIVE             	|
|-----------	|:------------------:	|-----------------------	|
| GET       	| /categories        	| List all categories   	|
| GET       	| /categories/{id}   	| List category by id   	|
| GET       	| /categories/{name} 	| List category by name 	|
      


