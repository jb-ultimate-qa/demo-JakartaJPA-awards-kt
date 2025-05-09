package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces

@Path("/hello")
class HelloResource {
    @GET
    @Produces("text/html")
    fun hello() = "Hello, User!" +
                "Try this URL:</br></br><a href=\"awards\">awards</a></br>" +
                "<a href=\"players\">players</a></br>" +
                "<a href=\"referee\">referee</a></br>"
}
