USE master;
IF DB_ID('KampregistreringDB') IS NOT NULL
ALTER DATABASE KampregistreringDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE KampregistreringDB;
CREATE DATABASE KampregistreringDB;
ALTER DATABASE KampregistreringDB SET MULTI_USER;
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

CREATE PROCEDURE insert_kamp @hjemmeHold INTEGER , @udeHold INTEGER
AS
INSERT INTO kampe (hjemme, ude) VALUES (@hjemmeHold, @udeHold);
GO

CREATE PROCEDURE insert_registrering @kamp INTEGER, @tidspunkt INTEGER, @haendelse INTEGER
AS
INSERT INTO registreringer (kamp, tidspunkt, haendelse) VALUES (@kamp, @tidspunkt, @haendelse);
GO

--select_registrering bliver ikke brugt.
CREATE PROCEDURE select_registrering @kamp int AS
SELECT * FROM registreringer WHERE kamp = @kamp ORDER BY registrerings_id;
GO



INSERT INTO hold (navn) VALUES
('Aalborg'),
('Aarhus'),
('Herning'),
('Koebenhavn'),
('Silkeborg');

INSERT INTO kampe (hjemme, ude) VALUES
(3,5),
(2,1),
(1,2),
(3,2);

INSERT INTO haendelser (haendelse) VALUES
('Maal hjemme'),
('Udvisning hjemme'),
('Maal ude'),
('Udvisning ude');

INSERT INTO registreringer (kamp, tidspunkt, haendelse) VALUES
(1,9,4),
(1,27,1),
(1,42,1),
(1,99,2),
(1,114,3),
(3,5,2),
(3,64,3),
(3,73,3),
(3,87,1),
(2,4,1),
(2,7,3),
(2,24,1),
(2,54,3),
(2,64,2),
(2,76,1),
(2,118,3);

--SELECT * FROM hold ORDER BY hold_id;
--SELECT hjemme, ude FROM kampe ORDER BY kamp_id;
--SELECT haendelse FROM haendelser ORDER BY haendelse_id;
SELECT kamp, tidspunkt, haendelse FROM registreringer ORDER BY kamp;