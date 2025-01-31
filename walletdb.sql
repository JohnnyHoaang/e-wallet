DROP TABLE Bank CASCADE CONSTRAINTS;
DROP TABLE Debit_Card CASCADE CONSTRAINTS;
DROP TABLE Credit_Card CASCADE CONSTRAINTS;
DROP TABLE Personal_Card CASCADE CONSTRAINTS;
DROP TABLE Cash CASCADE CONSTRAINTS;
DROP TABLE Note CASCADE CONSTRAINTS;
CREATE TABLE Bank(
    bank_id varchar2(100) primary key,
    amount number(7,2)
);

CREATE TABLE Debit_Card(
    card_name varchar2(100) NOT NULL,
    card_number varchar2(100) PRIMARY KEY,
    bank_id varchar2(100) references bank(bank_id)
);

CREATE TABLE Credit_Card(
    card_name varchar2(100) NOT NULL,
    card_number varchar2(100) PRIMARY KEY,
    expiry_date DATE NOT NULL,
    sec_code varchar2(100) NOT NULL,
    limit number(5) NOT NULL,
    balance number(7,2) NOT NULL
);

CREATE TABLE Cash(
    amount number(7,2) NOT NULL
);


CREATE TABLE Note(
    note_id number(3) primary key,
    creation_date DATE NOT NULL,
    text varchar2(100) NOT NULL,
    reminder_frequency varchar2(100) NOT NULL
);

CREATE TABLE Personal_Card(
    card_name varchar2(100) NOT NULL,
    card_number varchar2(100) PRIMARY KEY,
    expiry_date DATE NOT NULL
);