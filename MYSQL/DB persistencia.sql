-- CREATE DATABASE IF NOT EXISTS `pillam2`;
-- USE `pillam2`;

CREATE TABLE Escalador (
    id_escalador INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    alias VARCHAR(100),
    edat INT,
    nivell_maxim VARCHAR(5),
    estil_preferit ENUM('esportiva','classica','gel'),
    historial TEXT
);

CREATE TABLE Escola (
    id_escola INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE,
    lloc VARCHAR(100),
    aproximacio TEXT,
    numero_vies INT DEFAULT 0,
    popularitat ENUM('baixa','mitjana','alta'),
    restriccions TEXT
);

CREATE TABLE Sector (
    id_sector INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    coordenades VARCHAR(100),
    aproximacio TEXT,
    numero_vies INT DEFAULT 0,
    popularitat ENUM('baixa','mitjana','alta'),
    restriccions TEXT,
    escola_id INT NOT NULL,

    FOREIGN KEY (escola_id) REFERENCES Escola(id_escola),
    UNIQUE (nom, escola_id)
);

CREATE TABLE Via (
    id_via INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    tipus ENUM('esportiva','classica','gel') NOT NULL,
    orientacio ENUM('N','NE','NO','SE','SO','E','O','S'),
    estat ENUM('apte','construccio','tancada') DEFAULT 'apte',
    data_fi_estat DATE,
    escola_id INT,
    sector_id INT,
    ancoratge VARCHAR(20),
    tipus_roca ENUM('conglomerat','granit','calcaria','arenisca','altres'),
    creador_id INT,

    FOREIGN KEY (escola_id) REFERENCES Escola(id_escola),
    FOREIGN KEY (sector_id) REFERENCES Sector(id_sector),
    FOREIGN KEY (creador_id) REFERENCES Escalador(id_escalador)
);

CREATE TABLE Via_Gel (
    id_via INT PRIMARY KEY,

    FOREIGN KEY (id_via) REFERENCES Via(id_via) ON DELETE CASCADE
);

CREATE TABLE Via_Classica (
    id_via INT PRIMARY KEY,

    FOREIGN KEY (id_via) REFERENCES Via(id_via) ON DELETE CASCADE
);

CREATE TABLE Via_Esportiva (
    id_via INT PRIMARY KEY,
    llargada INT CHECK (llargada BETWEEN 5 AND 30),
    grau VARCHAR(5),

    FOREIGN KEY (id_via) REFERENCES Via(id_via) ON DELETE CASCADE
);

CREATE TABLE Llarg (
    id_llarg SERIAL PRIMARY KEY,
    via_id INT,
    llargada INT CHECK (llargada BETWEEN 15 AND 30),
    grau VARCHAR(5),

    FOREIGN KEY (via_id) REFERENCES Via(id_via) ON DELETE CASCADE
);

CREATE TABLE Escalador_Via (
    escalador_id INT,
    via_id INT,

    PRIMARY KEY (escalador_id, via_id),
    FOREIGN KEY (escalador_id) REFERENCES Escalador(id_escalador) ON DELETE CASCADE,
    FOREIGN KEY (via_id) REFERENCES Via(id_via) ON DELETE CASCADE
);
    
