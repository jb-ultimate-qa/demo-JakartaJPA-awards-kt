package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.utils.HtmlHelper.generateHtmlLinksForHello

@Path("/hello")
class HelloResource {
    @GET
    @Produces("text/html")
    fun hello() = "Hello, User! " + generateHtmlLinksForHello("awards", "players", "referee", "licenses")
}
