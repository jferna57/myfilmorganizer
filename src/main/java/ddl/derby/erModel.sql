
/* Drop Tables */

DROP TABLE FILM;




/* Create Tables */

CREATE TABLE FILM
(
	ID_FILM INT NOT NULL,
	TITLE VARCHAR(100),
	IMAGE BLOB(5000),
	LOCATION VARCHAR(3000),
	FILENAME VARCHAR(100),
	MD5 VARCHAR(5000),
	LAST_CHANGE DATE,
	PRIMARY KEY (ID_FILM)
);


