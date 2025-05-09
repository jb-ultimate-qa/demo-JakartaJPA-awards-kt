package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.HqlQueries
import my.example.awards.queries.JpqlQueries
import my.example.awards.queries.SqlQueries

@Path("/awards")
@Produces("text/plain")
class AwardsResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String
        get() = "Try this URL:</br></br><a href=\"" +
                "awards/jpql-get-all\">awards/jpql-get-all</a></br><a href=\"" +
                "awards/hql-get-all\">awards/hql-get-all</a></br><a href=\"" +
                "awards/hql-get-awards-of-high-rated-players\">awards/hql-get-awards-of-high-rated-players</a></br><a href=\"" +
                "awards/sql-get-awards-after-2022\">awards/sql-get-awards-after-2022</a>"

    @get:Path("jpql-get-all")
    @get:GET
    val allAwards: String?
        get() {
            val jpqlQueries = JpqlQueries()
            return jpqlQueries.allAwards
        }

    @get:Path("hql-get-all")
    @get:GET
    val allAwardsHibernate: String?
        get() {
            val hqlQueries = HqlQueries()
            return hqlQueries.allAwards
        }

    @get:Path("hql-get-awards-of-high-rated-players")
    @get:GET
    val awardsOfHighRatedPlayers: String?
        get() {
            val hqlQueries = HqlQueries()
            return hqlQueries.awardsOfHighRatedPlayers
        }

    @get:Path("sql-get-awards-after-2022")
    @get:GET
    val awardsAfter2022: String?
        get() {
            val sqlQueries = SqlQueries()
            return sqlQueries.awardsAfter2022
        }
}
