package my.example.awards.queries

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects

class JpqlQueries {
    private val entityManager: EntityManager?

    init {
        try { // use unit from persistence.xml
            val entityManagerFactory = Persistence.createEntityManagerFactory("jpa-default")
            entityManager = entityManagerFactory.createEntityManager()
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }
    }

    val allAwards: String
        get() { // works
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
}
