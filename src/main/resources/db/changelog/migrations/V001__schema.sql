

CREATE TABLE CUSTOMERS (
                           id SERIAL PRIMARY KEY ,
                           name varchar NOT NULL ,
                           surname varchar NOT NULL ,
                           age int,
                           phone_number varchar NOT NULL
);

CREATE TABLE ORDERS (
                        id SERIAL PRIMARY KEY ,
                        date date NOT NULL ,
                        customer_id int NOT NULL ,
                        product_name varchar NOT NULL ,
                        amount int NOT NULL ,
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);