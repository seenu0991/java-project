create schema "ROOT"
CREATE TABLE IDENTITIES
    (IDENTITY_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY, 
    uid VARCHAR(255) NOT NULL PRIMARY KEY,
    display_name VARCHAR(255),
    email_id VARCHAR(255)
    );
  
    create table Auth(
userName int NOT NULL PRIMARY KEY,
password varchar(255),
IDENTITY_ID int,
FOREIGN KEY(IDENTITY_ID)
REFERENCES IDENTITIES(IDENTITY_ID)
);

DROP TABLE IDENTITIES