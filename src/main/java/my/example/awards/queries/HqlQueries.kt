package my.example.awards.queries

import my.example.awards.model.Award
import my.example.awards.model.Referee
import my.example.awards.utils.QueryResultPrettier.concatenateObjects
import my.example.awards.utils.QueryResultPrettier.printObjects
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

class HqlQueries {
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

    val allAwards: String
        get() { // works
            val session = sessionFactory!!.openSession()
            val results = session
                .createQuery<Award?>("FROM Award a", Award::class.java)
                .resultList

            printObjects<Award?>(results)
            return concatenateObjects<Award?>(results)
        }

    val awardsOfHighRatedPlayers: String
        get() {
            val session = sessionFactory!!.openSession()
            val results = session
                .createQuery<Award?>("FROM Award a where a.winner.rating >= 1200", Award::class.java)
                .resultList

            printObjects<Award?>(results)
            return concatenateObjects<Award?>(results)
        }

    fun getRefereeByLicenceNumber(licenceNumber: String?): String {
        val session = sessionFactory!!.openSession()
        val results = session
            .createQuery<Referee?>("FROM Referee r where r.license.licenseNumber = :ln", Referee::class.java)
            .setParameter("ln", licenceNumber)
            .resultList

        printObjects<Referee?>(results)
        return concatenateObjects<Referee?>(results)
    }
}
