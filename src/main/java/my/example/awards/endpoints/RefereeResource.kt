package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.HqlQueries

@Path("/referee")
class RefereeResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String
        get() = "Try this URL:</br></br><a href=\"" +
                "referee/hql-get-with-licence-number\">referee/hql-get-with-licence-number</a></br>"

    @get:Path("hql-get-with-licence-number")
    @get:GET
    val refereeByLicenceNumber: String?
        get() {
            val hqlQueries = HqlQueries()
            return hqlQueries.getRefereeByLicenceNumber("LR001")
        }
}
