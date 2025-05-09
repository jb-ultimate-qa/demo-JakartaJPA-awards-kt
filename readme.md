**Jakarta EE 10 demo project**
- JPA (Hibernate)
- JAX-RS

JPQL, HQL, SQL queries for PostgreSQL DB, sample data is in resources.

Need to use application server to run this app.

Example configuration is in `.idea/runConfigurations/JBoss_WildFly_35_0_0_Final.xml`



**Endpoints:**
* `/hello` - just text with links to other endpoints
* `/awards` - list of queries
* `/awards/jpql-get-all` - JPQL query using persistence.EntityManager
* `/awards/hql-get-all`  - HQL query using hibernate.SessionFactory
* `/awards/hql-get-awards-of-high-rated-players` - HQL query with condition
* `/awards/sql-get-awards-after-2022` - Native SQL query using persistence.EntityManager
* `/players` - list of queries
* `/players/jpql-get-from-sport-club` - JPQL query with parameter
* `/referee/` - list of queries
* `/referee/hql-get-with-licence-number` - HQL query with parameter