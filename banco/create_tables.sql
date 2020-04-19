-- SEQUENCE: public.categoria_id_seq

-- DROP SEQUENCE public.categoria_id_seq;

CREATE SEQUENCE public.categoria_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.categoria_id_seq
    OWNER TO postgres;

-- drop table categoria cascade;
create table categoria
(
    id serial PRIMARY KEY,
    nome VARCHAR (50) UNIQUE NOT NULL
);

-----------------------------------------------------------------------

-- SEQUENCE: public.fatura_id_seq

-- DROP SEQUENCE public.fatura_id_seq;

CREATE SEQUENCE public.fatura_id_seq
    INCREMENT 1
    START 22
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.fatura_id_seq
    OWNER TO postgres;
	
-- drop table fatura;
create table fatura
(
	id serial PRIMARY KEY,
	mes character varying(100) NOT NULL,
	data_vencimento date not null,
	valor double precision not null,
	data_pagamento date null
);

--------------------------------------------------------------------------------------------
-- SEQUENCE: public.lancamento_categoria_id_seq

-- DROP SEQUENCE public.lancamento_categoria_id_seq;

CREATE SEQUENCE public.lancamento_categoria_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.lancamento_categoria_id_seq
    OWNER TO postgres;
---------------------------------------------------
-- SEQUENCE: public.lancamento_fatura_id_seq

-- DROP SEQUENCE public.lancamento_fatura_id_seq;

CREATE SEQUENCE public.lancamento_fatura_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.lancamento_fatura_id_seq
    OWNER TO postgres;
---------------------------------------------------
-- SEQUENCE: public.lancamento_id_seq

-- DROP SEQUENCE public.lancamento_id_seq;

CREATE SEQUENCE public.lancamento_id_seq
    INCREMENT 1
    START 337
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.lancamento_id_seq
    OWNER TO postgres;
---------------------------------------------------
-- SEQUENCE: public.responsavel_id_seq

-- DROP SEQUENCE public.responsavel_id_seq;

CREATE SEQUENCE public.responsavel_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.responsavel_id_seq
    OWNER TO postgres;
---------------------------------------------------

---------------------------------------------------

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