DROP TABLE IF EXISTS Gateway;
DROP TABLE IF EXISTS  Peripheral;

CREATE TABLE Gateway(
    SERIAL_NUMBER varchar primary key ,
    NAME varchar (100) not null ,
    iPv4address varchar (100) not null
);

CREATE TABLE Peripheral(
    uid int primary key,
    vendor varchar (100) not null ,
    DATE_CREATED DATE not null ,
    ONLINE_STATUS bit not NULL ,
    SERIAL_NUMBER varchar (100) not null
)
