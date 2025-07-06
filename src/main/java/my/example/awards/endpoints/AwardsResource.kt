package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.HqlQueries
import my.example.awards.queries.JpqlQueries
import my.example.awards.queries.SqlQueries
import my.example.awards.utils.HtmlHelper.generateHtmlLinks

@Path("/awards")
@Produces("text/plain")
class AwardsResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String
        get() = generateHtmlLinks("awards",
            "jpql-get-all",
            "hql-get-all",
            "hql-get-awards-of-high-rated-players",
            "sql-get-awards-after-2022")

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
