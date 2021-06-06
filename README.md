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


## Class Diagram

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
      
- [ ] Implement Deliveryman class
      
- [ ] Implement DTO
      
- [ ] Implement DeliverymanRepository
      
- [ ] Implement DeliverymanMapper
      
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


| CLASS 	| ENDPOINT                	| OBJECTIVE                       	|
|------:	|-------------------------	|---------------------------------	|
| USER  	| GET /users              	| List all users by birth order   	|
| USER  	| GET /users/{name}/found 	| List user by name               	|
| USER  	| POST /users                 | Insert a user                   	|
| USER  	| PUT users/updated           | Update a user                	|
| USER  	| DELETE users/{id}/removed   | Delete a user by ID 	            | 
|DELIVERYMAN| GET /deliverymans           | List all deliverymans by registered date 	            | 
|DELIVERYMAN| GET /deliverymans/{email}/found          | List  deliverymans by  email 	            | 
|DELIVERYMAN| POST /deliverymans           | Insert a Deliveryman 	            | 
|DELIVERYMAN| PUT /deliverymans/updated           | Update a deliveryman 	            | 
|DELIVERYMAN| DELETE /deliverymans/{ID}/removed          | Delete a deliveryman by ID 		            | 



