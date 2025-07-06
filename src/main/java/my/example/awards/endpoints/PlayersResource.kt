package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.JpqlQueries
import my.example.awards.utils.HtmlHelper.generateHtmlLinks

@Path("/players")
@Produces("text/plain")
class PlayersResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String = generateHtmlLinks("players", "jpql-get-from-sport-club")

    @get:Path("jpql-get-from-sport-club")
    @get:GET
    val playersFormCitySportClub: String? = JpqlQueries.getPlayersBySchool("City Sports Club")
}
