package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.HqlQueries
import my.example.awards.utils.HtmlHelper.generateHtmlLinks

@Path("/referee")
class RefereeResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String
        get() = generateHtmlLinks("referee", "hql-get-with-licence-number")

    @get:Path("hql-get-with-licence-number")
    @get:GET
    val refereeByLicenceNumber: String?
        get() {
            val hqlQueries = HqlQueries()
            return hqlQueries.getRefereeByLicenceNumber("LR001")
        }
}
