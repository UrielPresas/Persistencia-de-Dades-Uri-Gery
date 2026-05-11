USE pillam;

ALTER TABLE sector
DROP FOREIGN KEY sector_ibfk_1;

ALTER TABLE sector
ADD CONSTRAINT sector_ibfk_1
FOREIGN KEY (escola_id)
REFERENCES escola(id_escola)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE via
DROP FOREIGN KEY via_ibfk_1;

ALTER TABLE via
ADD CONSTRAINT via_ibfk_1
FOREIGN KEY (sector_id)
REFERENCES sector(id_sector)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE via
DROP FOREIGN KEY via_ibfk_2;

ALTER TABLE via
ADD CONSTRAINT via_ibfk_2
FOREIGN KEY (creador_id)
REFERENCES escalador(id_escalador)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE llarg
DROP FOREIGN KEY llarg_ibfk_1;

ALTER TABLE llarg
ADD CONSTRAINT llarg_ibfk_1
FOREIGN KEY (via_id)
REFERENCES via(id_via)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE via_check_escalador
DROP FOREIGN KEY via_creador_ibfk_1;

ALTER TABLE via_check_escalador
ADD CONSTRAINT via_creador_ibfk_1
FOREIGN KEY (via_id)
REFERENCES via(id_via)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE via_check_escalador
DROP FOREIGN KEY via_creador_ibfk_1;

ALTER TABLE via_check_escalador
ADD CONSTRAINT via_creador_ibfk_1
FOREIGN KEY (via_id)
REFERENCES via(id_via)
ON DELETE CASCADE;

ALTER TABLE via_check_escalador
DROP FOREIGN KEY via_creador_ibfk_2;

ALTER TABLE via_check_escalador
ADD CONSTRAINT via_creador_ibfk_2
FOREIGN KEY (escalador_id)
REFERENCES escalador(id_escalador)
ON DELETE CASCADE;