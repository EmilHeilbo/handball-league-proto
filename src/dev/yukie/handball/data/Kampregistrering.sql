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

CREATE TABLE h�ndelser (
	h�ndelse_id int IDENTITY NOT NULL,
	h�ndelse nvarchar(20)

	CONSTRAINT UC_H�ndelse UNIQUE (h�ndelse),
	CONSTRAINT PK_H�ndelse PRIMARY KEY(h�ndelse_id)
);

CREATE TABLE registrering(
	registrerings_id int IDENTITY NOT NULL,
	kamp int NOT NULL,
	tidspunkt int NOT NULL,
	h�ndelse int NOT NULL

	CONSTRAINT PK_Registrering PRIMARY KEY (registrerings_id),
	CONSTRAINT FK_Kamp         FOREIGN KEY (kamp)     REFERENCES kampe(kamp_id),
	CONSTRAINT FK_H�ndelse    FOREIGN KEY (h�ndelse) REFERENCES h�ndelser(h�ndelse_id),
);