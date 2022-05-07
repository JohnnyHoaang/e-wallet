DROP PROCEDURE DELETE_NOTES;
DROP PROCEDURE DELETE_CREDITCARDS;
DROP PROCEDURE DELETE_PERSONALCARDS;
DROP PROCEDURE DELETE_CASH;
/
CREATE OR REPLACE PROCEDURE DELETE_NOTES
AS
BEGIN
    for arow in (SELECT * FROM NOTE) LOOP
        DELETE FROM NOTE WHERE note_id = arow.note_id;
    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE DELETE_CREDITCARDS
AS
BEGIN
    for arow in (SELECT * FROM credit_card) LOOP
        DELETE FROM credit_card WHERE card_number = arow.card_number;
    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE DELETE_DEBITCARDS
AS
BEGIN
    for arow in (SELECT * FROM DEBIT_CARD) LOOP
        DELETE FROM DEBIT_CARD WHERE card_number = arow.card_number;
    END LOOP;
    for arow in (select * from bank) LOOP
        DELETE FROM BANK WHERE BANK_ID = arow.bank_id;
    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE DELETE_PERSONALCARDS
AS
BEGIN
    for arow in (SELECT * FROM PERSONAL_CARD) LOOP
        DELETE FROM PERSONAL_CARD WHERE card_number = arow.card_number;
    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE DELETE_CASH
AS
BEGIN
    for arow in (SELECT * FROM CASH) LOOP
        DELETE FROM CASH WHERE amount = arow.amount;
    END LOOP;
END;
/