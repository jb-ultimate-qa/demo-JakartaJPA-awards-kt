package my.example.awards.queries

import my.example.awards.model.Award
import my.example.awards.model.License
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

class SqlQueries {
    private val sessionFactory: SessionFactory?

    init {
        try {
            sessionFactory = Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
        } catch (ex: Throwable) {
            throw ExceptionInInitializerError(ex)
        }
    }

    val awardsAfter2022: String
        get() {
            val session = sessionFactory!!.openSession()
            val results = session
                .createNativeQuery("select * from award where award.year_ > 2023;", Award::class.java)
                .resultList

            printObjects<Any?>(results)
            return concatenateObjects<Any?>(results)
        }

    val licensesNamedQuery: String
        get() {
            val session = sessionFactory!!.openSession()
            val results = session
                .createNamedQuery("SQL.License.findByLicenseNumber102", License::class.java)
                .resultList

            printObjects<Any?>(results)
            return concatenateObjects<Any?>(results)
        }
}
