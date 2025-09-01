DROP TABLE IF EXISTS radio;

CREATE TABLE radio (
	ID			SERIAL			PRIMARY KEY,
	name	VARCHAR(255)	NOT NULL	UNIQUE,
	streamurl		VARCHAR(255)	NOT NULL	UNIQUE,
	genre	VARCHAR(255)	NOT NULL,
	country	VARCHAR(255)	NOT NULL,
	isfavorite	BOOLEAN NOT NULL
);

INSERT INTO radio (name, streamurl, genre, country, isfavorite) VALUES ('Punkrockers Radio - 192 Kbps', 'http://stream.punkrockers-radio.de:8000/mp3', 'Punkrock,Punk,Rock,Hardcore,Ska,Oi,Alternative,Various', 'UK', FALSE);
INSERT INTO radio (name, streamurl, genre, country, isfavorite) VALUES ('Hirschmilch Progressive - 128 Kbps', 'http://hirschmilch.de:7000', 'Misc', 'UK', FALSE);