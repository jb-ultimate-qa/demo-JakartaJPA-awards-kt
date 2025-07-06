package my.example.awards.queries

import jakarta.persistence.EntityManager
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects
import org.hibernate.cfg.Configuration

class JpqlQueries {
    private val entityManager: EntityManager?

    init {
        try {
            entityManager = Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory().createEntityManager()
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }
    }

    val allAwards: String
        get() {
            val results = entityManager!!
                .createQuery("FROM Award a")
                .resultList

            printObjects<Any?>(results)
            return concatenateObjects<Any?>(results)
        }

    fun getPlayersBySchool(sportSchoolName: String?): String {
        val results = entityManager!!
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

    fun getLicenseUsingNamingQuery(): String {
        val results = entityManager!!
            .createNamedQuery("HQL.License.findByLicenseNumber103")
            .resultList
        printObjects<Any?>(results)
        return concatenateObjects<Any?>(results)
    }
}
