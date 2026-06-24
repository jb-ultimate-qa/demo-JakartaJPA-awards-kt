### About project
- Jakarta EE 10
- JPA (Hibernate)
- JAX-RS

JPQL, HQL, SQL queries for PostgreSQL DB, sample data is in resources.

Need to use application server to run this app. Example configurations are located in `.idea/runConfigurations`

- better to use Tomcat, the project is prepared for it
- to use WildFly, open pom.xml, uncomment CDI and JAX-RS specifications and comment its implementations. Otherwise, there will be runtime errors
  - *note: WildFly has its own datastore defined in domain.xml file, and server use it after starting application. So there could be troubles with "hibernate validate" mode.*


**Endpoints:**
* `/hello` - start page with links to other endpoints
* `/awards` - list of queries
  * `/awards/jpql-get-all` - JPQL query using persistence.EntityManager
  * `/awards/hql-get-all`  - HQL query using hibernate.SessionFactory
  * `/awards/hql-get-awards-of-high-rated-players` - HQL query with condition
  * `/awards/sql-get-awards-after-2022` - Native SQL query using persistence.EntityManager
* `/players` - list of queries
  * `/players/jpql-get-from-sport-club` - JPQL query with parameter
* `/referee` - list of queries
  * `/referee/hql-get-with-licence-number` - HQL query with parameter