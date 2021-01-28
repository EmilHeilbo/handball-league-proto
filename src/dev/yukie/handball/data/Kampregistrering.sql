USE master;
IF DB_ID('KampregistreringDB') IS NOT NULL
DROP DATABASE KampregistreringDB;
CREATE DATABASE KampregistreringDB;
GO


USE KampregistreringDB;
CREATE TABLE hold (
  	hold_id int IDENTITY NOT NULL,
  	navn nvarchar(20) NOT NULL
  
  	CONSTRAINT UC_Hold UNIQUE (navn),
 	CONSTRAINT PK_Hold PRIMARY KEY (hold_id)
);

CREATE TABLE kampe (
	kamp_id int IDENTITY NOT NULL,
	hjemme int NOT NULL,
	ude int NOT NULL

	CONSTRAINT UC_Kamp   UNIQUE (kamp_id),
	CONSTRAINT PK_Kamp   PRIMARY KEY (hjemme, ude),
	CONSTRAINT FK_Hjemme FOREIGN KEY (hjemme) REFERENCES hold(hold_id),
	CONSTRAINT FK_Ude    FOREIGN KEY (ude)    REFERENCES hold(hold_id),
	CONSTRAINT CHK_Hold  CHECK (hjemme!=ude)
);

CREATE TABLE haendelser (
	haendelse_id int IDENTITY NOT NULL,
	haendelse nvarchar(20)

	CONSTRAINT UC_Haendelse UNIQUE (haendelse),
	CONSTRAINT PK_Haendelse PRIMARY KEY(haendelse_id)
);

CREATE TABLE registreringer(
	registrerings_id int IDENTITY NOT NULL,
	kamp int NOT NULL,
	tidspunkt int NOT NULL,
	haendelse int NOT NULL

	CONSTRAINT PK_Registrering PRIMARY KEY (registrerings_id),
	CONSTRAINT FK_Kamp         FOREIGN KEY (kamp)     REFERENCES kampe(kamp_id),
	CONSTRAINT FK_Haendelse    FOREIGN KEY (haendelse) REFERENCES haendelser(haendelse_id),
);

GO

CREATE PROCEDURE insert_hold @navn nvarchar(20)
AS
INSERT INTO hold (navn) VALUES (@navn);
GO

CREATE PROCEDURE select_registrering @kamp int AS
SELECT * FROM registreringer WHERE kamp_id = @kamp ORDER BY registrering_id;
GO



INSERT INTO hold (navn) VALUES
('Aalborg'),
('Aarhus'),
('Herning'),
('Koebenhavn'),
('Silkeborg');

SELECT * FROM hold ;