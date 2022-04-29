DROP TABLE Bank CASCADE CONSTRAINTS;
DROP TABLE Debit_Card CASCADE CONSTRAINTS;
DROP TABLE Credit_Card CASCADE CONSTRAINTS;
DROP TABLE Cash CASCADE CONSTRAINTS;
DROP TABLE Note CASCADE CONSTRAINTS;
CREATE TABLE Bank(
    bank_id varchar2(100) primary key,
    amount number(7,2)
);

CREATE TABLE Debit_Card(
    card_name varchar2(100),
    card_number varchar2(100),
    bank_id varchar2(100) references bank(bank_id)
);

CREATE TABLE Credit_Card(
    card_name varchar2(100),
    card_number varchar2(100),
    expiry_date Date,
    sec_code varchar2(100),
    limit number(5),
    balance number(7,2)
);

CREATE TABLE Cash(
    amount number(7,2)
);


CREATE TABLE Note(
    note_id number(3) primary key,
    creation_date Date,
    text varchar2(100),
    reminder_frequency varchar2(100)
);

CREATE TABLE Personal_Card(
    card_name varchar2(100),
    card_number varchar2(100),
    expiry_date varchar2(100)
);