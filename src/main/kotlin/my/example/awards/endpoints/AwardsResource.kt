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
    val links: String = generateHtmlLinks("awards",
        "jpql-get-all",
        "hql-get-all",
        "hql-get-awards-of-high-rated-players",
        "sql-get-awards-after-2022")

    @get:Path("jpql-get-all")
    @get:GET
    val allAwards: String? = JpqlQueries.allAwards

    @get:Path("hql-get-all")
    @get:GET
    val allAwardsHibernate: String? = HqlQueries.allAwards

    @get:Path("hql-get-awards-of-high-rated-players")
    @get:GET
    val awardsOfHighRatedPlayers: String? = HqlQueries.awardsOfHighRatedPlayers

    @get:Path("sql-get-awards-after-2022")
    @get:GET
    val awardsAfter2022: String? = SqlQueries.awardsAfter2022
}
