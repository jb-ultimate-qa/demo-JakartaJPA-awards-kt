package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.JpqlQueries

@Path("/players")
@Produces("text/plain")
class PlayersResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String
        get() = "Try this URL:</br></br><a href=\"" +
                "players/jpql-get-from-sport-club\">players/jpql-get-from-sport-club</a></br>"

    @get:Path("jpql-get-from-sport-club")
    @get:GET
    val playersFormCitySportClub: String?
        get() {
            val jpqlQueries = JpqlQueries()
            return jpqlQueries.getPlayersBySchool("City Sports Club")
        }
}
