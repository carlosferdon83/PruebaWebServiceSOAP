/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Carlos Fernando
 * Created: 1/10/2019
 */

--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2019-10-01 01:59:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'LATIN8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16872)
-- Name: pruebas; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA pruebas;


ALTER SCHEMA pruebas OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 204 (class 1259 OID 16965)
-- Name: address; Type: TABLE; Schema: pruebas; Owner: postgres
--

CREATE TABLE pruebas.address (
    id_address integer NOT NULL,
    street character varying(50) NOT NULL,
    suite character varying(50) NOT NULL,
    city character varying(50) NOT NULL,
    zipcode character varying(50) NOT NULL,
    id_geo integer NOT NULL
);


ALTER TABLE pruebas.address OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16963)
-- Name: address_id_address_seq; Type: SEQUENCE; Schema: pruebas; Owner: postgres
--

CREATE SEQUENCE pruebas.address_id_address_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pruebas.address_id_address_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 203
-- Name: address_id_address_seq; Type: SEQUENCE OWNED BY; Schema: pruebas; Owner: postgres
--

ALTER SEQUENCE pruebas.address_id_address_seq OWNED BY pruebas.address.id_address;


--
-- TOC entry 206 (class 1259 OID 16978)
-- Name: company; Type: TABLE; Schema: pruebas; Owner: postgres
--

CREATE TABLE pruebas.company (
    id_company integer NOT NULL,
    name character varying(30) NOT NULL,
    catchphrase character varying(30) NOT NULL,
    bs character varying(30) NOT NULL
);


ALTER TABLE pruebas.company OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16976)
-- Name: company_id_company_seq; Type: SEQUENCE; Schema: pruebas; Owner: postgres
--

CREATE SEQUENCE pruebas.company_id_company_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pruebas.company_id_company_seq OWNER TO postgres;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 205
-- Name: company_id_company_seq; Type: SEQUENCE OWNED BY; Schema: pruebas; Owner: postgres
--

ALTER SEQUENCE pruebas.company_id_company_seq OWNED BY pruebas.company.id_company;


--
-- TOC entry 202 (class 1259 OID 16957)
-- Name: geo; Type: TABLE; Schema: pruebas; Owner: postgres
--

CREATE TABLE pruebas.geo (
    id_geo integer NOT NULL,
    lat character varying(50) NOT NULL,
    lng character varying(50) NOT NULL
);


ALTER TABLE pruebas.geo OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16955)
-- Name: geo_id_geo_seq; Type: SEQUENCE; Schema: pruebas; Owner: postgres
--

CREATE SEQUENCE pruebas.geo_id_geo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pruebas.geo_id_geo_seq OWNER TO postgres;

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 201
-- Name: geo_id_geo_seq; Type: SEQUENCE OWNED BY; Schema: pruebas; Owner: postgres
--

ALTER SEQUENCE pruebas.geo_id_geo_seq OWNED BY pruebas.geo.id_geo;


--
-- TOC entry 198 (class 1259 OID 16904)
-- Name: operaciones; Type: TABLE; Schema: pruebas; Owner: postgres
--

CREATE TABLE pruebas.operaciones (
    idoperacion integer NOT NULL,
    nombre character varying(30) NOT NULL
);


ALTER TABLE pruebas.operaciones OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16902)
-- Name: operaciones_idoperacion_seq; Type: SEQUENCE; Schema: pruebas; Owner: postgres
--

CREATE SEQUENCE pruebas.operaciones_idoperacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pruebas.operaciones_idoperacion_seq OWNER TO postgres;

--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 197
-- Name: operaciones_idoperacion_seq; Type: SEQUENCE OWNED BY; Schema: pruebas; Owner: postgres
--

ALTER SEQUENCE pruebas.operaciones_idoperacion_seq OWNED BY pruebas.operaciones.idoperacion;


--
-- TOC entry 207 (class 1259 OID 16985)
-- Name: persona; Type: TABLE; Schema: pruebas; Owner: postgres
--

CREATE TABLE pruebas.persona (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    id_address integer NOT NULL,
    phone character varying(50) NOT NULL,
    website character varying(50) NOT NULL,
    id_company integer NOT NULL
);


ALTER TABLE pruebas.persona OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16914)
-- Name: resultados; Type: TABLE; Schema: pruebas; Owner: postgres
--

CREATE TABLE pruebas.resultados (
    idresultado integer NOT NULL,
    operando1 integer NOT NULL,
    operando2 integer NOT NULL,
    resultado integer NOT NULL,
    idoperacion integer NOT NULL
);


ALTER TABLE pruebas.resultados OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16912)
-- Name: resultados_idresultado_seq; Type: SEQUENCE; Schema: pruebas; Owner: postgres
--

CREATE SEQUENCE pruebas.resultados_idresultado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pruebas.resultados_idresultado_seq OWNER TO postgres;

--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 199
-- Name: resultados_idresultado_seq; Type: SEQUENCE OWNED BY; Schema: pruebas; Owner: postgres
--

ALTER SEQUENCE pruebas.resultados_idresultado_seq OWNED BY pruebas.resultados.idresultado;


--
-- TOC entry 2717 (class 2604 OID 16968)
-- Name: address id_address; Type: DEFAULT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.address ALTER COLUMN id_address SET DEFAULT nextval('pruebas.address_id_address_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 16981)
-- Name: company id_company; Type: DEFAULT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.company ALTER COLUMN id_company SET DEFAULT nextval('pruebas.company_id_company_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 16960)
-- Name: geo id_geo; Type: DEFAULT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.geo ALTER COLUMN id_geo SET DEFAULT nextval('pruebas.geo_id_geo_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 16907)
-- Name: operaciones idoperacion; Type: DEFAULT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.operaciones ALTER COLUMN idoperacion SET DEFAULT nextval('pruebas.operaciones_idoperacion_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 16917)
-- Name: resultados idresultado; Type: DEFAULT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.resultados ALTER COLUMN idresultado SET DEFAULT nextval('pruebas.resultados_idresultado_seq'::regclass);


--
-- TOC entry 2865 (class 0 OID 16965)
-- Dependencies: 204
-- Data for Name: address; Type: TABLE DATA; Schema: pruebas; Owner: postgres
--

COPY pruebas.address (id_address, street, suite, city, zipcode, id_geo) FROM stdin;
\.


--
-- TOC entry 2867 (class 0 OID 16978)
-- Dependencies: 206
-- Data for Name: company; Type: TABLE DATA; Schema: pruebas; Owner: postgres
--

COPY pruebas.company (id_company, name, catchphrase, bs) FROM stdin;
\.


--
-- TOC entry 2863 (class 0 OID 16957)
-- Dependencies: 202
-- Data for Name: geo; Type: TABLE DATA; Schema: pruebas; Owner: postgres
--

COPY pruebas.geo (id_geo, lat, lng) FROM stdin;
\.


--
-- TOC entry 2859 (class 0 OID 16904)
-- Dependencies: 198
-- Data for Name: operaciones; Type: TABLE DATA; Schema: pruebas; Owner: postgres
--

COPY pruebas.operaciones (idoperacion, nombre) FROM stdin;
1	SUMA
2	RESTA
3	MULTIPLICACION
4	DIVISION
\.


--
-- TOC entry 2868 (class 0 OID 16985)
-- Dependencies: 207
-- Data for Name: persona; Type: TABLE DATA; Schema: pruebas; Owner: postgres
--

COPY pruebas.persona (id, name, username, email, id_address, phone, website, id_company) FROM stdin;
\.


--
-- TOC entry 2861 (class 0 OID 16914)
-- Dependencies: 200
-- Data for Name: resultados; Type: TABLE DATA; Schema: pruebas; Owner: postgres
--

COPY pruebas.resultados (idresultado, operando1, operando2, resultado, idoperacion) FROM stdin;
2	25	25	625	3
3	25	5	5	4
4	25	5	30	1
5	3	3	9	3
\.


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 203
-- Name: address_id_address_seq; Type: SEQUENCE SET; Schema: pruebas; Owner: postgres
--

SELECT pg_catalog.setval('pruebas.address_id_address_seq', 1, false);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 205
-- Name: company_id_company_seq; Type: SEQUENCE SET; Schema: pruebas; Owner: postgres
--

SELECT pg_catalog.setval('pruebas.company_id_company_seq', 1, false);


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 201
-- Name: geo_id_geo_seq; Type: SEQUENCE SET; Schema: pruebas; Owner: postgres
--

SELECT pg_catalog.setval('pruebas.geo_id_geo_seq', 1, false);


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 197
-- Name: operaciones_idoperacion_seq; Type: SEQUENCE SET; Schema: pruebas; Owner: postgres
--

SELECT pg_catalog.setval('pruebas.operaciones_idoperacion_seq', 4, true);


--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 199
-- Name: resultados_idresultado_seq; Type: SEQUENCE SET; Schema: pruebas; Owner: postgres
--

SELECT pg_catalog.setval('pruebas.resultados_idresultado_seq', 5, true);


--
-- TOC entry 2728 (class 2606 OID 16970)
-- Name: address address_pk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.address
    ADD CONSTRAINT address_pk PRIMARY KEY (id_address);


--
-- TOC entry 2730 (class 2606 OID 16983)
-- Name: company company_pk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.company
    ADD CONSTRAINT company_pk PRIMARY KEY (id_company);


--
-- TOC entry 2726 (class 2606 OID 16962)
-- Name: geo geo_pk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.geo
    ADD CONSTRAINT geo_pk PRIMARY KEY (id_geo);


--
-- TOC entry 2732 (class 2606 OID 16989)
-- Name: persona id_pk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.persona
    ADD CONSTRAINT id_pk PRIMARY KEY (id);


--
-- TOC entry 2720 (class 2606 OID 16909)
-- Name: operaciones idoperacion_pk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.operaciones
    ADD CONSTRAINT idoperacion_pk PRIMARY KEY (idoperacion);


--
-- TOC entry 2722 (class 2606 OID 16911)
-- Name: operaciones operacion_uk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.operaciones
    ADD CONSTRAINT operacion_uk UNIQUE (nombre);


--
-- TOC entry 2724 (class 2606 OID 16919)
-- Name: resultados resultado_pk; Type: CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.resultados
    ADD CONSTRAINT resultado_pk PRIMARY KEY (idresultado);


--
-- TOC entry 2735 (class 2606 OID 16990)
-- Name: persona address_fk; Type: FK CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.persona
    ADD CONSTRAINT address_fk FOREIGN KEY (id) REFERENCES pruebas.address(id_address);


--
-- TOC entry 2736 (class 2606 OID 16995)
-- Name: persona company_fk; Type: FK CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.persona
    ADD CONSTRAINT company_fk FOREIGN KEY (id_company) REFERENCES pruebas.company(id_company);


--
-- TOC entry 2734 (class 2606 OID 16971)
-- Name: address geo_fk; Type: FK CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.address
    ADD CONSTRAINT geo_fk FOREIGN KEY (id_geo) REFERENCES pruebas.geo(id_geo);


--
-- TOC entry 2733 (class 2606 OID 16920)
-- Name: resultados operacion_fk; Type: FK CONSTRAINT; Schema: pruebas; Owner: postgres
--

ALTER TABLE ONLY pruebas.resultados
    ADD CONSTRAINT operacion_fk FOREIGN KEY (idoperacion) REFERENCES pruebas.operaciones(idoperacion);


-- Completed on 2019-10-01 01:59:07

--
-- PostgreSQL database dump complete
--

