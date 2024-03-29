/* Drop Tables */
DROP TABLE film;

/* Create Tables */

CREATE TABLE FILM
(
	ID_FILM BIGINT NOT NULL,
	TITLE VARCHAR(100),
	LOCATION VARCHAR(3000),
	FILENAME VARCHAR(100),
	LAST_CHANGE DATE,
	IMAGE BLOB(5000),
	PRIMARY KEY (ID_FILM)
);
