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


/* Insert default values */

INSERT INTO film VALUES ( 1, 'title-1', 'location-1', 'filename-1', '01/01/2010' , null );
INSERT INTO film VALUES ( 2, 'title-2', 'location-2', 'filename-2', '02/01/2010' , null );
INSERT INTO film VALUES ( 3, 'title-3', 'location-3', 'filename-3', '03/01/2010' , null );
INSERT INTO film VALUES ( 4, 'title-4', 'location-4', 'filename-4', '04/01/2010' , null );
INSERT INTO film VALUES ( 5, 'title-5', 'location-5', 'filename-5', '05/01/2010' , null );