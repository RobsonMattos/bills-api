-- drop table categoria cascade;
create table categoria
(
    id serial PRIMARY KEY,
    nome VARCHAR (50) UNIQUE NOT NULL
);

-- drop table fatura;
create table fatura
(
	id serial PRIMARY KEY,
	mes character varying(100) NOT NULL,
	data_vencimento date not null,
	valor double precision not null,
	data_pagamento date null
);

-- drop table lancamento cascade;
CREATE TABLE lancamento
(
    id serial primary key,
    estabelecimento character varying(100) NOT NULL,
    data date,
    valor double precision,
    categoria_id integer,
    fatura_id integer,
    parcela integer,
    quantidade_parcelas integer,
    observacao character varying(200) NULL,
    responsavel character varying(100) not null,
    FOREIGN KEY (categoria_id) REFERENCES categoria (id),
    FOREIGN KEY (fatura_id) REFERENCES fatura (id)
);


create table usuario
(
    id serial primary key,
    username varchar(32),
    password varchar(64)
);