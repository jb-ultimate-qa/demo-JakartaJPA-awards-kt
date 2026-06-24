package my.example.awards.queries

import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects

object JpqlQueries {

    val entityManagerFactory: EntityManagerFactory = try {
            Persistence.createEntityManagerFactory("jpa-default")
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }

    val allAwards: String
        get() {
            entityManagerFactory.createEntityManager().use { entityManager ->
                val results = entityManager
                    .createQuery("FROM Award a")
                    .getResultList()

                printObjects(results)
                return concatenateObjects(results)
            }
        }

    fun getPlayersBySchool(sportSchoolName: String?): String {
        entityManagerFactory.createEntityManager().use { entityManager ->
            val results = entityManager
                .createQuery(
                    """
                    select pl.fullName from Player pl
                        join pl.sportSchools ss
                        where ss.title = ?1
                    """.trimIndent()
                )
                .setParameter(1, sportSchoolName)
                .resultList

            printObjects<Any?>(results)
            return concatenateObjects<Any?>(results)
        }
    }

    fun getLicenseUsingNamingQuery(): String {
        entityManagerFactory.createEntityManager().use { entityManager ->
            val results = entityManager
                .createNamedQuery("HQL.License.findByLicenseNumber103")
                .resultList
            printObjects<Any?>(results)
            return concatenateObjects<Any?>(results)
        }
    }
}
