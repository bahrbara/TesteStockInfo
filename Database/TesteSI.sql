toc.dat                                                                                             0000600 0004000 0002000 00000017250 13517067740 0014456 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP           &                w            TesteSI    10.9    10.9                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                    0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                    1262    16393    TesteSI    DATABASE     �   CREATE DATABASE "TesteSI" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "TesteSI";
             postgres    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                    0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                     3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                    0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1         �            1259    16490    account    TABLE     �   CREATE TABLE public.account (
    id_account integer NOT NULL,
    balance double precision,
    type character(1),
    id_client integer
);
    DROP TABLE public.account;
       public         postgres    false    3         �            1259    16480    client    TABLE       CREATE TABLE public.client (
    id_client integer NOT NULL,
    name character varying,
    cpf character varying,
    gender character(1),
    age integer,
    birth_date date,
    email character varying,
    phone_number character varying,
    adress character varying
);
    DROP TABLE public.client;
       public         postgres    false    3         �            1259    16500    deposit    TABLE     �   CREATE TABLE public.deposit (
    id_deposit integer NOT NULL,
    value double precision,
    date date,
    id_client integer
);
    DROP TABLE public.deposit;
       public         postgres    false    3         �            1259    16505 	   operation    TABLE     k   CREATE TABLE public.operation (
    id_account integer,
    id_withdraw integer,
    id_deposit integer
);
    DROP TABLE public.operation;
       public         postgres    false    3         �            1259    16495    withdraw    TABLE     �   CREATE TABLE public.withdraw (
    id_withdraw integer NOT NULL,
    value double precision,
    date date,
    id_client integer
);
    DROP TABLE public.withdraw;
       public         postgres    false    3                   0    16490    account 
   TABLE DATA               G   COPY public.account (id_account, balance, type, id_client) FROM stdin;
    public       postgres    false    197       2823.dat           0    16480    client 
   TABLE DATA               l   COPY public.client (id_client, name, cpf, gender, age, birth_date, email, phone_number, adress) FROM stdin;
    public       postgres    false    196       2822.dat 	          0    16500    deposit 
   TABLE DATA               E   COPY public.deposit (id_deposit, value, date, id_client) FROM stdin;
    public       postgres    false    199       2825.dat 
          0    16505 	   operation 
   TABLE DATA               H   COPY public.operation (id_account, id_withdraw, id_deposit) FROM stdin;
    public       postgres    false    200       2826.dat           0    16495    withdraw 
   TABLE DATA               G   COPY public.withdraw (id_withdraw, value, date, id_client) FROM stdin;
    public       postgres    false    198       2824.dat �
           2606    16494    account account_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id_account);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public         postgres    false    197         ~
           2606    16489    client client_id_client_cpf_key 
   CONSTRAINT     d   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_id_client_cpf_key UNIQUE (id_client, cpf);
 I   ALTER TABLE ONLY public.client DROP CONSTRAINT client_id_client_cpf_key;
       public         postgres    false    196    196         �
           2606    16487    client client_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public         postgres    false    196         �
           2606    16504    deposit deposit_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.deposit
    ADD CONSTRAINT deposit_pkey PRIMARY KEY (id_deposit);
 >   ALTER TABLE ONLY public.deposit DROP CONSTRAINT deposit_pkey;
       public         postgres    false    199         �
           2606    16499    withdraw withdraw_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.withdraw
    ADD CONSTRAINT withdraw_pkey PRIMARY KEY (id_withdraw);
 @   ALTER TABLE ONLY public.withdraw DROP CONSTRAINT withdraw_pkey;
       public         postgres    false    198         �
           2606    16508    account fk_account    FK CONSTRAINT     {   ALTER TABLE ONLY public.account
    ADD CONSTRAINT fk_account FOREIGN KEY (id_client) REFERENCES public.client(id_client);
 <   ALTER TABLE ONLY public.account DROP CONSTRAINT fk_account;
       public       postgres    false    197    2688    196         �
           2606    16518    deposit fk_deposit    FK CONSTRAINT     {   ALTER TABLE ONLY public.deposit
    ADD CONSTRAINT fk_deposit FOREIGN KEY (id_client) REFERENCES public.client(id_client);
 <   ALTER TABLE ONLY public.deposit DROP CONSTRAINT fk_deposit;
       public       postgres    false    199    196    2688         �
           2606    16523    operation fk_operation_0    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT fk_operation_0 FOREIGN KEY (id_withdraw) REFERENCES public.withdraw(id_withdraw);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT fk_operation_0;
       public       postgres    false    200    2692    198         �
           2606    16528    operation fk_operation_1    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT fk_operation_1 FOREIGN KEY (id_deposit) REFERENCES public.deposit(id_deposit);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT fk_operation_1;
       public       postgres    false    2694    199    200         �
           2606    16533    operation fk_operation_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT fk_operation_2 FOREIGN KEY (id_account) REFERENCES public.account(id_account);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT fk_operation_2;
       public       postgres    false    2690    200    197         �
           2606    16513    withdraw fk_withdraw    FK CONSTRAINT     }   ALTER TABLE ONLY public.withdraw
    ADD CONSTRAINT fk_withdraw FOREIGN KEY (id_client) REFERENCES public.client(id_client);
 >   ALTER TABLE ONLY public.withdraw DROP CONSTRAINT fk_withdraw;
       public       postgres    false    196    2688    198                                                                                                                                                                                                                                                                                                                                                                2823.dat                                                                                            0000600 0004000 0002000 00000000005 13517067740 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           2822.dat                                                                                            0000600 0004000 0002000 00000000005 13517067740 0014254 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           2825.dat                                                                                            0000600 0004000 0002000 00000000005 13517067740 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           2826.dat                                                                                            0000600 0004000 0002000 00000000005 13517067740 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           2824.dat                                                                                            0000600 0004000 0002000 00000000005 13517067740 0014256 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000015612 13517067740 0015403 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 10.9
-- Dumped by pg_dump version 10.9

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE ONLY public.withdraw DROP CONSTRAINT fk_withdraw;
ALTER TABLE ONLY public.operation DROP CONSTRAINT fk_operation_2;
ALTER TABLE ONLY public.operation DROP CONSTRAINT fk_operation_1;
ALTER TABLE ONLY public.operation DROP CONSTRAINT fk_operation_0;
ALTER TABLE ONLY public.deposit DROP CONSTRAINT fk_deposit;
ALTER TABLE ONLY public.account DROP CONSTRAINT fk_account;
ALTER TABLE ONLY public.withdraw DROP CONSTRAINT withdraw_pkey;
ALTER TABLE ONLY public.deposit DROP CONSTRAINT deposit_pkey;
ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
ALTER TABLE ONLY public.client DROP CONSTRAINT client_id_client_cpf_key;
ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
DROP TABLE public.withdraw;
DROP TABLE public.operation;
DROP TABLE public.deposit;
DROP TABLE public.client;
DROP TABLE public.account;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    id_account integer NOT NULL,
    balance double precision,
    type character(1),
    id_client integer
);


ALTER TABLE public.account OWNER TO postgres;

--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id_client integer NOT NULL,
    name character varying,
    cpf character varying,
    gender character(1),
    age integer,
    birth_date date,
    email character varying,
    phone_number character varying,
    adress character varying
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: deposit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deposit (
    id_deposit integer NOT NULL,
    value double precision,
    date date,
    id_client integer
);


ALTER TABLE public.deposit OWNER TO postgres;

--
-- Name: operation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.operation (
    id_account integer,
    id_withdraw integer,
    id_deposit integer
);


ALTER TABLE public.operation OWNER TO postgres;

--
-- Name: withdraw; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.withdraw (
    id_withdraw integer NOT NULL,
    value double precision,
    date date,
    id_client integer
);


ALTER TABLE public.withdraw OWNER TO postgres;

--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (id_account, balance, type, id_client) FROM stdin;
\.
COPY public.account (id_account, balance, type, id_client) FROM '$$PATH$$/2823.dat';

--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id_client, name, cpf, gender, age, birth_date, email, phone_number, adress) FROM stdin;
\.
COPY public.client (id_client, name, cpf, gender, age, birth_date, email, phone_number, adress) FROM '$$PATH$$/2822.dat';

--
-- Data for Name: deposit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.deposit (id_deposit, value, date, id_client) FROM stdin;
\.
COPY public.deposit (id_deposit, value, date, id_client) FROM '$$PATH$$/2825.dat';

--
-- Data for Name: operation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.operation (id_account, id_withdraw, id_deposit) FROM stdin;
\.
COPY public.operation (id_account, id_withdraw, id_deposit) FROM '$$PATH$$/2826.dat';

--
-- Data for Name: withdraw; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.withdraw (id_withdraw, value, date, id_client) FROM stdin;
\.
COPY public.withdraw (id_withdraw, value, date, id_client) FROM '$$PATH$$/2824.dat';

--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id_account);


--
-- Name: client client_id_client_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_id_client_cpf_key UNIQUE (id_client, cpf);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);


--
-- Name: deposit deposit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deposit
    ADD CONSTRAINT deposit_pkey PRIMARY KEY (id_deposit);


--
-- Name: withdraw withdraw_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.withdraw
    ADD CONSTRAINT withdraw_pkey PRIMARY KEY (id_withdraw);


--
-- Name: account fk_account; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fk_account FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- Name: deposit fk_deposit; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deposit
    ADD CONSTRAINT fk_deposit FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- Name: operation fk_operation_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation
    ADD CONSTRAINT fk_operation_0 FOREIGN KEY (id_withdraw) REFERENCES public.withdraw(id_withdraw);


--
-- Name: operation fk_operation_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation
    ADD CONSTRAINT fk_operation_1 FOREIGN KEY (id_deposit) REFERENCES public.deposit(id_deposit);


--
-- Name: operation fk_operation_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation
    ADD CONSTRAINT fk_operation_2 FOREIGN KEY (id_account) REFERENCES public.account(id_account);


--
-- Name: withdraw fk_withdraw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.withdraw
    ADD CONSTRAINT fk_withdraw FOREIGN KEY (id_client) REFERENCES public.client(id_client);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      