package my.example.awards.queries

import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import my.example.awards.model.Award
import my.example.awards.model.License
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects
import kotlin.use


object SqlQueries {
    val entityManagerFactory: EntityManagerFactory = try {
            Persistence.createEntityManagerFactory("jpa-default")
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }

    val awardsAfter2022: String
        get() {
            entityManagerFactory.createEntityManager().use { entityManager ->
                val results = entityManager
                    .createNativeQuery("select * from award where award.year_ > 2023;", Award::class.java)
                    .resultList

                printObjects<Any?>(results)
                return concatenateObjects<Any?>(results)
            }
        }

    val licensesNamedQuery: String
        get() {
            entityManagerFactory.createEntityManager().use { entityManager ->
                val results = entityManager
                    .createNamedQuery("SQL.License.findByLicenseNumber102", License::class.java)
                    .resultList

                printObjects<Any?>(results)
                return concatenateObjects<Any?>(results)
            }
        }
}
