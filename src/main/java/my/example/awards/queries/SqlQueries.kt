package my.example.awards.queries

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence
import my.example.awards.model.Award
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects

class SqlQueries {
    private val entityManager: EntityManager?

    init {
        try { // use unit from persistence.xml
            entityManager = Persistence.createEntityManagerFactory("jpa-default")
                .createEntityManager()
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }
    }

    val awardsAfter2022: String
        get() { //works
            val results = entityManager!!
                .createNativeQuery("select * from award where award.year_ > 2023;", Award::class.java)
                .resultList

            printObjects<Any?>(results)
            return concatenateObjects<Any?>(results)
        }
}
