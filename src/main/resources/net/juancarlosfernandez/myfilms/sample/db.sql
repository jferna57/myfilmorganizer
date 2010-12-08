
create table users (
	id varchar(80) not null,
	name varchar(80) not null,
	constraint pk_user primary key (id)
);


insert into users VALUES ( 'u1',  'Pocoyo' );
insert into users VALUES ( 'u2',  'Pato'    );
insert into users VALUES ( 'u3',  'Eli'    );
insert into users VALUES ( 'u4',  'Valentina'    );


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

insert into film values ( 1, "title-1", null, "location-1", "filename-1", "md5-1", null );