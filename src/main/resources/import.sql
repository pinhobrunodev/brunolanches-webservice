INSERT INTO tb_category(name) values ('PASTA');
INSERT INTO tb_category(name) values ('PIZZA');
INSERT INTO tb_category(name) values ('SANDWICH');
INSERT INTO tb_category(name) values ('DRINK');
INSERT INTO tb_category(name) values ('VEGAN');

INSERT INTO tb_product(name,description,price) values ('SPAGHETTI BOLOGNESE','A DELICIOUS PASTA MADE WITH LOTS OF LOVE',20.00);
INSERT INTO tb_product(name,description,price) values ('SPAGHETTI WITH GARLIC AND OIL','A PERFECT SPAGHETTI FOR YOUR MEAL',25.00);
INSERT INTO tb_product(name,description,price) values ('PEPPERONI PIZZA','A DELICIOUS PEPPERONI PIZZA MADE WITH THE BEST INGREDIENTS',15.00);
INSERT INTO tb_product(name,description,price) values ('MOZZARELLA PIZZA','A DELICIOUS MOZZARELLA PIZZA MADE WITH THE BEST INGREDIENTS',15.00);
INSERT INTO tb_product(name,description,price) values ('X-BURGUER','A DELICIOUS X-BURGUER',10.00);
INSERT INTO tb_product(name,description,price) values ('AMERICAN BURGUER','A DELICIOUS SANDWICH WITH LOTS OF SPICE AND LOVE',10.00);
INSERT INTO tb_product(name,description,price) values ('TOFU SANDWICH','A DELICIOUS AND NATURAL SANDWICH WITH LOTS OF LOVE',15.00);
INSERT INTO tb_product(name,description,price) values ('COKE','A DELICIOUS COLD DRINK',2.00);
INSERT INTO tb_product(name,description,price) values ('BEER','A DELICIOUS BEER',3.00);
INSERT INTO tb_product(name,description,price) values ('REDBULL','A DRINK TO KEEP YOU AWAKE',4.00);
INSERT INTO tb_product(name,description,price) values ('ORANJE JUICE','A VERY TASTY AND NATURAL JUICE',1.50);

INSERT INTO tb_product_category(category_id,product_id) values (1,1);
INSERT INTO tb_product_category(category_id,product_id) values (1,2);
INSERT INTO tb_product_category(category_id,product_id) values (5,2);
INSERT INTO tb_product_category(category_id,product_id) values (5,7);
INSERT INTO tb_product_category(category_id,product_id) values (2,3);
INSERT INTO tb_product_category(category_id,product_id) values (2,4);
INSERT INTO tb_product_category(category_id,product_id) values (3,5);
INSERT INTO tb_product_category(category_id,product_id) values (3,6);
INSERT INTO tb_product_category(category_id,product_id) values (3,7);
INSERT INTO tb_product_category(category_id,product_id) values (4,8);
INSERT INTO tb_product_category(category_id,product_id) values (4,9);
INSERT INTO tb_product_category(category_id,product_id) values (4,10);
INSERT INTO tb_product_category(category_id,product_id) values (4,11);




