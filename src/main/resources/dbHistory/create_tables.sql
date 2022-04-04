--1.Create the sequence: survivor_seq
CREATE SEQUENCE survivor_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 1000000
NOCACHE
NOCYCLE;

--2.Create the table: survivor
CREATE TABLE survivor(
id				NUMBER PRIMARY KEY,
name        	VARCHAR2(20 CHAR),
age             NUMBER(3),
gender          VARCHAR2(1 CHAR),
last_latitude	VARCHAR2(5 CHAR),
last_longitude	VARCHAR2(5 CHAR),
is_infected	    VARCHAR2(1 CHAR)	DEFAULT 'N'
);

--3.Create the comment on table and column
COMMENT ON TABLE TTT.survivor IS 'This table holds all survivor detail';
COMMENT ON COLUMN survivor.id IS 'It is auto generated using sequence: survivor_seq';
COMMENT ON COLUMN survivor.name IS 'Holds the survivor name';
COMMENT ON COLUMN survivor.age IS 'Holds the age of survivor';
COMMENT ON COLUMN survivor.gender IS 'Holds the gender of survivor';
COMMENT ON COLUMN survivor.last_latitude IS 'Holds the last location-latitude';
COMMENT ON COLUMN survivor.last_longitude IS 'Holds the last location-longitude';
COMMENT ON COLUMN survivor.is_infected IS 'Holds the infected status as Y for yes or N for No.';
