DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS transactions;

CREATE TABLE purchases(purchase_id serial PRIMARY KEY, name VARCHAR(255), price INTEGER);

CREATE TABLE transactions(transaction_id serial PRIMARY KEY, date_of_purchase DATE, purchase_id INTEGER, price INTEGER);

DROP SEQUENCE IF EXISTS purchase_seq;
CREATE SEQUENCE purchase_seq START 1;

DROP SEQUENCE IF EXISTS transaction_seq;
CREATE SEQUENCE transaction_seq START 1;
