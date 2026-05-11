# README Tècnic - Decisions de Disseny del Projecte Pillam

## Objectiu del projecte

L'objectiu principal del projecte ha estat desenvolupar una aplicació de consola en Java per gestionar informació relacionada amb escoles d'escalada.

Més enllà de la funcionalitat, s'ha prioritzat una estructura modular, escalable i mantenible aplicant bones pràctiques de programació orientada a objectes i separació de responsabilitats.

---

## Separació per capes

El projecte s'ha dividit en diferents capes per evitar barrejar responsabilitats.

### Vista

La capa Vista s'encarrega exclusivament de la interacció amb l'usuari.

S'ha separat en diferents classes:

* ViaVista
* EscolaVista
* SectorVista
* EscaladorVista

### Per què?

Inicialment tota la lògica estava centralitzada en una sola classe.

Aquesta aproximació generava:

* Classes massa llargues
* Dificultat per localitzar funcionalitats
* Baixa mantenibilitat
* Codi repetit

Separar cada entitat en la seva pròpia vista permet:

* Organització més clara
* Facilitat de manteniment
* Millor escalabilitat
* Menor acoblament

Cada vista gestiona exclusivament el CRUD de la seva entitat.

---

## Ús del patró DAO

S'ha implementat el patró DAO (Data Access Object).

### Per què?

Aquest patró separa l'accés a dades de la lògica de negoci.

Això permet que la capa Vista no necessiti conèixer:

* Consultes SQL
* Connexions JDBC
* Detalls de persistència

Exemple:

ViaVista només crida:

viaDAO.modificar(via)

Sense necessitat de saber com es construeix la consulta SQL.

### Avantatges

* Separació de responsabilitats
* Reutilització
* Facilitat de manteniment
* Possibilitat de canviar de motor de base de dades amb menys impacte

---

## Implementació MySQL específica

S'han creat classes concretes:

* MySQLViaDAO
* MySQLEscolaDAO
* MySQLSectorDAO
* MySQLEscaladorDAO

### Per què?

Permet desacoblar la interfície de la implementació.

Això faria possible, en un futur, crear implementacions com:

* PostgreSQLViaDAO
* MongoViaDAO

sense modificar la resta del sistema.

---

## Models i DTOs

S'han separat:

### Models

Representen les entitats completes de base de dades.

Exemple:
Via

### DTOs

S'utilitzen per consultes específiques.

Exemple:

* ViaDifDTO
* ViaEstatDTO
* ViaLlargaDTO

### Per què?

No totes les consultes necessiten retornar l'objecte complet.

Això permet:

* Millor rendiment
* Menys dades innecessàries
* Classes més especialitzades

---

## Encapsulació de regles de negoci

Les regles relacionades amb l'estat d'una via s'han implementat dins del model Via.

Exemple:

aplicarReglesEstat()

### Per què?

Aquesta lògica forma part del comportament de l'objecte.

Si es deixés a la Vista:

* Es duplicaria codi
* Es dispersaria la lògica
* Seria més difícil de mantenir

Centralitzar-la al model garanteix coherència.

---

## Validacions contextuals

S'han aplicat validacions depenent del tipus de via.

Exemple:

Els ancoratges disponibles varien segons:

* Esportiva
* Clàssica
* Gel

### Per què?

Això garanteix integritat funcional.

No tindria sentit permetre valors incompatibles amb el domini del problema.

---

## Gestió de claus foranes i integritat referencial

S'ha utilitzat ON DELETE CASCADE a les relacions necessàries.

### Per què?

Permet mantenir consistència automàtica.

Exemple:

Eliminar un sector elimina automàticament les vies associades.

Sense això, caldria eliminar manualment totes les dependències.

---

## Ús de LocalDate

Per gestionar dates s'ha escollit LocalDate.

### Per què?

És l'opció moderna de Java.

Avantatges:

* API més clara
* Millor manipulació de dates
* Evita problemes de java.util.Date

---

## Decisió d'interfície per consola

S'ha triat una aplicació de consola.

### Per què?

L'objectiu del projecte era treballar:

* arquitectura
* persistència
* lògica de negoci

Una interfície gràfica hauria desviat el focus cap a la presentació.

---

## Problemes trobats durant el desenvolupament

### Restriccions de claus foranes

Es van produir errors d'integritat en insercions i eliminacions.

Solució:
revisió de relacions i configuració cascade.

### Gestió de enters buits

Els parseInt provocaven errors en modificacions.

Solució:
validar amb isBlank() abans de parsejar.

### Actualització de regles automàtiques

Inicialment les restriccions es modificaven manualment.

Solució:
automatitzar-ho mitjançant aplicarReglesEstat().

---

## Conclusions

El projecte ha permès aplicar conceptes avançats de desenvolupament Java:

* Arquitectura per capes
* Patró DAO
* Integritat referencial
* Validacions de domini
* Encapsulació
* Disseny modular

Les decisions preses busquen fer el codi més robust, escalable i fàcil de mantenir.
