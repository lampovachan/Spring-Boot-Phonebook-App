CREATE TABLE contacts
(
    contact_id  SERIAL,
    user_id  INTEGER NOT NULL,
    name  CHAR(18) NOT NULL,
    surname  CHAR(18) NULL,
    middlename  CHAR(18) NULL,
    mobilephone  CHAR(18) NOT NULL,
    workphone  CHAR(18) NULL,
    address  CHAR(40) NULL,
    email CHAR(30) NULL,
    PRIMARY KEY (contact_id)
);



CREATE TABLE users
(
    user_id SERIAL,
    name  TEXT NOT NULL,
    surname  CHAR(18) NULL,
    middlename  CHAR(18) NULL,
    login  VARCHAR(30) NOT NULL,
    password  VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)

);

ALTER TABLE contacts
    ADD FOREIGN KEY (user_id) REFERENCES users(user_id);