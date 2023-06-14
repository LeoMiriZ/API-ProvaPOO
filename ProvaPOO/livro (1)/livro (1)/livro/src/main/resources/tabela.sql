CREATE DATABASE IF NOT EXISTS menu;
USE menu;


CREATE TABLE IF NOT EXISTS menu
(
    id varchar(36),
    prato varchar(200) NOT NULL,
    preco FLOAT NOT NULL,
    CONSTRAINT id_pkey PRIMARY KEY (id)
);