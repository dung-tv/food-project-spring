-- drop table if exists role;
-- drop table if exists user;
-- drop table if exists user_roles;
-- create table role (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=MyISAM;
-- create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM;

-- user1@random.edu / admin
insert into admin_users (email, enabled, first_name, last_name, password, phone, token_expired, id, created_at) values ('admin1@random.edu', 1, 'user1', 'user1', '$2a$10$y8NanRk6KII5oMMh.fJsKO1tHZCjphJ6eIsgxqHus87ciSxhWaEEy', '1234567789', 0, 1, current_date());
insert into admin_users (email, enabled, first_name, last_name, password, phone, token_expired, id, created_at) values ('admin2@random.edu', 1, 'user1', 'user1', '$2a$10$y8NanRk6KII5oMMh.fJsKO1tHZCjphJ6eIsgxqHus87ciSxhWaEEy', '1234567789', 0, 2, current_date());
insert into customer_users (email, enabled, first_name, last_name, password, phone, token_expired, id, created_at) values ('user2@random.edu', 1, 'user1', 'user1', '$2a$10$y8NanRk6KII5oMMh.fJsKO1tHZCjphJ6eIsgxqHus87ciSxhWaEEy', '1234567789', 0, 3, current_date());

INSERT INTO admin_roles (name, created_at) VALUES ('ADMIN', current_date());
INSERT INTO admin_roles (name, created_at) VALUES ('CUSTOMER', current_date());

insert into admin_users_roles (user_id, role_id) values (1, 1);
insert into admin_users_roles (user_id, role_id) values (3, 2);

-- INSERT INTO admin_privileges (name) VALUES ('READ_ROLE');
-- INSERT INTO admin_privileges (name) VALUES ('WRITE_ROLE');
-- INSERT INTO admin_privileges (name) VALUES ('EDIT_ROLE');
-- INSERT INTO admin_privileges (name) VALUES ('DELETE_ROLE');

INSERT INTO admin_privileges (id, name, description, created_at) VALUES (1,'USER_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (2,'USER_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (3,'USER_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (4,'USER_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (5,'USER_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (6,'UROLE_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (7,'UROLE_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (8,'UROLE_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (9,'UROLE_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (10,'UROLE_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (11,'PRIVILEGE_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (12,'PRIVILEGE_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (13,'PRIVILEGE_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (14,'PRIVILEGE_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (15,'PRIVILEGE_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (16,'CATEGORY_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (17,'CATEGORY_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (18,'CATEGORY_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (19,'CATEGORY_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (20,'CATEGORY_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (21,'INGREDIENT_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (22,'INGREDIENT_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (23,'INGREDIENT_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (24,'INGREDIENT_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (25,'INGREDIENT_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (26,'MENU_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (27,'MENU_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (28,'MENU_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (29,'MENU_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (30,'MENU_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (31,'ORDER_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (32,'ORDER_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (33,'ORDER_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (34,'ORDER_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (35,'ORDER_DELETE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (36,'RESTAURANT_GET_ALL','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (37,'RESTAURANT_GET_ONE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (38,'RESTAURANT_CREATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (39,'RESTAURANT_UPDATE','management', current_date());
INSERT INTO admin_privileges (id, name, description, created_at) VALUES (40,'RESTAURANT_DELETE','management', current_date());

INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 1);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 2);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 3);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 4);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 5);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 6);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 7);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 8);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 9);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 10);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 11);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 12);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 13);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 14);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 15);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 16);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 17);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 18);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 19);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 20);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 21);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 22);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 23);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 24);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 25);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 26);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 27);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 28);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 29);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 30);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 31);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 32);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 33);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 34);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 35);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 36);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 37);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 38);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 39);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (1, 40);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 16);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 17);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 18);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 19);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 20);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 21);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 22);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 23);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 24);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 25);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 26);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 27);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 28);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 29);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 30);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 31);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 32);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 33);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 34);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 35);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 36);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 37);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 38);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 39);
INSERT INTO admin_roles_privileges (role_id, privilege_id) VALUES (2, 40);

INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');
INSERT INTO categories (name, thumbnail_pic) VALUES ('string', 'http://192.168.56.1:8088/categories/downloadFile/sdt_army.png');

INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);
INSERT INTO restaurants(city, description, email, house, location, name, phone, pricing, rating, same_price, status, street, thumbnail_pic, verified)
VALUES('city', 'description', 'email', 'house', 'location', 'name', 'phone', 0, 1, 0, 1, 'street', 'http://192.168.56.1:8088/restaurants/downloadFile/sdt_army.png', 1);

INSERT INTO categories_restaurants(restaurant_id, category_id) VALUES (1, 1);
INSERT INTO categories_restaurants(restaurant_id, category_id) VALUES (2, 1);
INSERT INTO categories_restaurants(restaurant_id, category_id) VALUES (3, 1);
INSERT INTO categories_restaurants(restaurant_id, category_id) VALUES (1, 3);
INSERT INTO categories_restaurants(restaurant_id, category_id) VALUES (2, 2);
INSERT INTO categories_restaurants(restaurant_id, category_id) VALUES (3, 2);

INSERT INTO customers_restaurants_favorite(customer_id, restaurant_id) VALUES (3, 1);
INSERT INTO customers_restaurants_favorite(customer_id, restaurant_id) VALUES (3, 2);
INSERT INTO customers_restaurants_favorite(customer_id, restaurant_id) VALUES (3, 3);
INSERT INTO customers_restaurants_favorite(customer_id, restaurant_id) VALUES (3, 4);
INSERT INTO customers_restaurants_favorite(customer_id, restaurant_id) VALUES (3, 5);

INSERT INTO menus(name, price, thumbnail_pic, restaurant_id) VALUES('name', 0, 'http://192.168.56.1:8088/menus/downloadFile/sdt_army.png', 1);
INSERT INTO menus(name, price, thumbnail_pic, restaurant_id) VALUES('name', 0, 'http://192.168.56.1:8088/menus/downloadFile/sdt_army.png', 1);
INSERT INTO menus(name, price, thumbnail_pic, restaurant_id) VALUES('name', 0, 'http://192.168.56.1:8088/menus/downloadFile/sdt_army.png', 1);
INSERT INTO menus(name, price, thumbnail_pic, restaurant_id) VALUES('name', 0, 'http://192.168.56.1:8088/menus/downloadFile/sdt_army.png', 2);
INSERT INTO menus(name, price, thumbnail_pic, restaurant_id) VALUES('name', 0, 'http://192.168.56.1:8088/menus/downloadFile/sdt_army.png', 2);
INSERT INTO menus(name, price, thumbnail_pic, restaurant_id) VALUES('name', 0, 'http://192.168.56.1:8088/menus/downloadFile/sdt_army.png', 3);

INSERT INTO ingredients(name, price, thumbnail_pic) VALUES('name', 0, 'http://192.168.56.1:8088/ingredients/downloadFile/sdt_army.png');
INSERT INTO ingredients(name, price, thumbnail_pic) VALUES('name', 0, 'http://192.168.56.1:8088/ingredients/downloadFile/sdt_army.png');
INSERT INTO ingredients(name, price, thumbnail_pic) VALUES('name', 0, 'http://192.168.56.1:8088/ingredients/downloadFile/sdt_army.png');
INSERT INTO ingredients(name, price, thumbnail_pic) VALUES('name', 0, 'http://192.168.56.1:8088/ingredients/downloadFile/sdt_army.png');
INSERT INTO ingredients(name, price, thumbnail_pic) VALUES('name', 0, 'http://192.168.56.1:8088/ingredients/downloadFile/sdt_army.png');

INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (1, 1);
INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (2, 1);
INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (3, 1);
INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (1, 2);
INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (2, 2);
INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (1, 3);
INSERT INTO menus_ingredients(menu_id, ingredient_id) VALUES (1, 4);

