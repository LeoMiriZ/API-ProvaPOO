CREATE DATABASE IF NOT EXISTS menu;
USE menu;


CREATE TABLE IF NOT EXISTS menu
(
    id varchar(36),
    prato varchar(200) NOT NULL,
    preco FLOAT NOT NULL,
    CONSTRAINT id_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido
(
    id varchar(36),
    nump varchar(10) NOT NULL,
    total FLOAT NOT NULL,
    statusp varchar(20) NOT NULL,
    CONSTRAINT id_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS item
(
    id varchar(36),
    prato varchar(200) NOT NULL,
    preco FLOAT NOT NULL,
    CONSTRAINT id_pkey PRIMARY KEY (id)
);