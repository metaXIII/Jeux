
CREATE TABLE Support (
                id INT AUTO_INCREMENT NOT NULL,
                nom VARCHAR(10) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE Jeux (
                id INT AUTO_INCREMENT NOT NULL,
                nom VARCHAR(45) NOT NULL,
                supportId INT NOT NULL,
                available BOOLEAN NOT NULL,
                ended BOOLEAN NOT NULL,
                progress BOOLEAN NOT NULL,
                PRIMARY KEY (id)
);


ALTER TABLE Jeux ADD CONSTRAINT support_jeux_fk
FOREIGN KEY (id)
REFERENCES Support (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;