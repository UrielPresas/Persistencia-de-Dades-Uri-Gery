SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE via_check_escalador;
TRUNCATE TABLE via;
TRUNCATE TABLE escalador;
TRUNCATE TABLE sector;
TRUNCATE TABLE escola;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO escola (nom, lloc, aproximacio, numero_vies, popularitat, restriccions) VALUES
('Siurana','Tarragona','20min',120,'alta','cap'),
('Margalef','Tarragona','15min',200,'alta','cap'),
('Montsant','Tarragona','25min',90,'mitjana','cap'),
('Rodellar','Osca','30min',150,'alta','cap'),
('Terradets','Lleida','10min',80,'mitjana','cap'),
('Albarracin','Terol','5min',300,'alta','cap'),
('Patones','Madrid','15min',60,'baixa','cap'),
('Chulilla','Valencia','20min',180,'alta','cap'),
('Riglos','Osca','25min',70,'mitjana','cap'),
('Cavallers','Lleida','40min',50,'baixa','cap');


INSERT INTO sector (nom, coordenades, aproximacio, numero_vies, popularitat, restriccions, escola_id) VALUES
('El Pati','41.2,0.8','10min',30,'alta','cap',1),
('Can Piqui','41.2,0.8','15min',20,'mitjana','cap',1),
('Laboratori','41.3,0.9','10min',25,'alta','cap',2),
('Espadelles','41.3,0.9','12min',35,'alta','cap',2),
('Montsant Nord','41.1,0.7','20min',15,'baixa','cap',3),
('Cuevas','42.4,-0.1','25min',40,'alta','cap',4),
('Pared Negra','42.5,-0.2','30min',20,'mitjana','cap',4),
('Terradets Paret','42.0,0.7','5min',25,'alta','cap',5),
('Bloc Zona 1','40.4,-1.4','2min',100,'alta','cap',6),
('Bloc Zona 2','40.4,-1.4','3min',80,'alta','cap',6),
('Patones Sector','40.8,-3.4','10min',30,'mitjana','cap',7),
('Chulilla Wall','39.6,-0.8','15min',60,'alta','cap',8),
('Riglos Mallos','42.3,-0.7','20min',25,'alta','cap',9),
('Cavallers Estany','42.6,0.8','35min',15,'baixa','cap',10),
('Montsant Sud','41.1,0.7','25min',20,'mitjana','cap',3);

INSERT INTO escalador (nom, alias, edat, nivell_maxim, estil_preferit) VALUES
('Marc','Marquito',25,'7c','esportiva'),
('Anna','Aneta',22,'7a','classica'),
('Joan','Joanet',30,'8a','esportiva'),
('Laura','Laurix',27,'7b','gel'),
('Pau','Pausito',19,'6c','classica'),
('Clara','Claris',24,'7a','esportiva'),
('Nil','Nilo',21,'7b','gel'),
('Pol','Polito',28,'8a','esportiva'),
('Eva','Evix',26,'7c','gel'),
('Alex','Lex',23,'7a','classica'),
('Sara','Sarita',29,'7b','esportiva'),
('Oriol','Ori',31,'8b','esportiva'),
('Marta','Martis',20,'6b','gel'),
('David','Davi',35,'7c','gel'),
('Júlia','Juls',22,'7a','esportiva'),
('Eric','Erik',27,'8a','classica'),
('Nora','Nor',24,'7b','gel'),
('Hugo','Hug',26,'7c','esportiva'),
('Irene','Iri',23,'7a','classica'),
('Toni','Ton',33,'8a','esportiva');

SHOW COLUMNS FROM escalador;

INSERT INTO via (sector_id, creador_id, nom, tipus_via, orientacio, estat, data_fi_estat, ancoratge, tipus_roca, grau, restriccions) VALUES
(1,1,'La clásica','esportiva','S','apte',NULL,'parabolts','calcaria','6a',0),
(1,2,'Project X','esportiva','S','apte',NULL,'parabolts','calcaria','7b',0),
(2,3,'Vertical','esportiva','E','apte',NULL,'parabolts','calcaria','6c',0),
(3,4,'Overhang','esportiva','O','apte',NULL,'parabolts','conglomerat','7a',0),
(4,5,'Placa fina','esportiva','N','apte',NULL,'parabolts','calcaria','6b',0),
(5,6,'Fisura','classica','S','apte',NULL,'friends','granit','6a',0),
(6,7,'Cueva power','esportiva','S','apte',NULL,'parabolts','calcaria','7c',0),
(7,8,'Resistencia','esportiva','E','apte',NULL,'parabolts','calcaria','7b',0),
(8,9,'Paret gran','classica','N','apte',NULL,'friends','calcaria','6c',0),
(9,10,'Bloc 1','gel','S','apte',NULL,NULL,'arenisca','6A',0),
(10,11,'Bloc 2','gel','S','apte',NULL,NULL,'arenisca','6B',0),
(11,12,'Patones line','esportiva','S','apte',NULL,'parabolts','calcaria','6c',0),
(12,13,'Chulilla king','esportiva','S','apte',NULL,'parabolts','calcaria','7a',0),
(13,14,'Riglos epic','classica','O','apte',NULL,'friends','conglomerat','6b',0),
(14,15,'Alta muntanya','classica','N','apte',NULL,'friends','granit','6a',0),
(15,16,'Montsant flow','esportiva','S','apte',NULL,'parabolts','calcaria','7b',0),
(1,1,'Test 17','esportiva','S','apte',NULL,'parabolts','calcaria','6c',0),
(2,2,'Test 18','esportiva','E','apte',NULL,'parabolts','calcaria','7a',0),
(3,3,'Test 19','esportiva','O','apte',NULL,'parabolts','calcaria','7b',0),
(4,4,'Test 20','esportiva','N','apte',NULL,'parabolts','calcaria','6c',0),
(5,5,'Test 21','esportiva','S','apte',NULL,'parabolts','calcaria','7a',0),
(6,6,'Test 22','esportiva','E','apte',NULL,'parabolts','calcaria','6b',0),
(7,7,'Test 23','esportiva','O','apte',NULL,'parabolts','calcaria','7c',0),
(8,8,'Test 24','esportiva','N','apte',NULL,'parabolts','calcaria','7b',0),
(9,9,'Test 25','esportiva','S','apte',NULL,'parabolts','calcaria','6c',0),
(10,10,'Test 26','gel','S','apte',NULL,NULL,'arenisca','6A',0),
(11,11,'Test 27','gel','S','apte',NULL,NULL,'arenisca','6B',0),
(12,12,'Test 28','esportiva','S','apte',NULL,'parabolts','calcaria','7a',0),
(13,13,'Test 29','classica','O','apte',NULL,'friends','calcaria','6c',0),
(14,14,'Test 30','classica','N','apte',NULL,'friends','granit','6b',0);

TRUNCATE TABLE via_check_escalador;

INSERT INTO Via_Check_Escalador (via_id, escalador_id) VALUES
(1,1),(2,2),(3,3),(4,4),(5,5),
(6,6),(7,7),(8,8),(9,9),(10,10),
(11,11),(12,12),(13,13),(14,14),(15,15);