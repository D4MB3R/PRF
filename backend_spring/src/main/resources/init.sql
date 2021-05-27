DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS transactions;

CREATE TABLE purchases(purchase_id serial PRIMARY KEY, name VARCHAR(255), price INTEGER);

CREATE TABLE transactions(transaction_id serial PRIMARY KEY, date_of_purchase DATE, purchase_id INTEGER, price INTEGER);

DROP SEQUENCE IF EXISTS hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START 1;

