# generic-spring-boot-app
A CRUD template for creating spring boot app

You may execute this on your database to create items table:

CREATE TABLE ITEMS (
ID serial PRIMARY KEY,
ITEM_NAME VARCHAR(250),
ITEM_DESCRIPTION VARCHAR(500),
ITEM_PRICE NUMERIC
);

INSERT INTO items(ITEM_NAME, ITEM_DESCRIPTION, ITEM_PRICE, ITEM_IMAGE) 
VALUES('Playstation 5', 'A console released by SONY', 500, './images/upload');

COMMIT;
