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
      
- [X] Implement User class
      
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
      <summary>  Deliveryman Tasks ⌛️</summary>
      
- [X] Implement Deliveryman class
      
- [X] Implement DTO
      
- [X] Implement DeliverymanRepository
      
- [X] Implement DeliverymanMapper
      
- [ ] Implement DeliverymanService
      <ul>
    <li> - [ ] findAllOrderByRegisteredDate()</li>
    <li> - [ ] findByEmail()</li>
    <li> - [ ] insert()</li>
    <li> - [ ] update()</li>
    <li> - [ ] delete()</li>
      </ul>
- [ ] Implement DeliverymanController
- [ ] Implement DeliverymanExceptions
- [ ] Implement Validations in the DeliverymanService class
</details>







# 📌 Project Endpoints


### User Class

| HTTP VERB 	|       ENPOINT       	| OBJECTIVE                     	|
|-----------	|:-------------------:	|-------------------------------	|
| GET       	| /users              	| List all users by birth order 	|
| GET       	| /users/{name}/found 	| List user by name             	|
| POST      	| /user               	| Insert a user                 	|
| PUT       	| /user/updated       	| Update a user                 	|
| DELETE    	| /user/{id}/removed  	| Delete a user by id           	|



### Deliveryman Class

| HTTP VERB 	|       ENPOINT       	| OBJECTIVE                     	|
|-----------	|:-------------------:	|-------------------------------	|
| GET       	| /deliverymans              	| List all deliverymans by registered date 	|
| GET       	| /deliverymans/{email}/found 	| List  deliverymans by  email              	|
| POST      	| /deliverymans            	| Insert a Deliveryman                	|
| PUT       	|/deliverymans/updated      	|  Update a deliveryman                  	|
| DELETE    	| /deliverymans/{id}/removed  	| Delete a deliveryman by id           	|





