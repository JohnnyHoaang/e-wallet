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
    limit number(100),
    balance number(100),
    bank_id varchar2(100) references bank(bank_id)
);

CREATE TABLE Cash(
    amount number(100)
);

CREATE TABLE Bank(
    bank_id varchar2(100) primary key,
    amount number(100)
);

CREATE TABLE Note(
    note_id number(100) primary key,
    creation_date Date,
    text varchar2(100),
    reminder_frequency varchar2(100)
);