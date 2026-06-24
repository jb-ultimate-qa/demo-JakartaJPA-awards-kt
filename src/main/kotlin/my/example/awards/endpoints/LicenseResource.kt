package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.HqlQueries
import my.example.awards.queries.JpqlQueries
import my.example.awards.queries.SqlQueries
import my.example.awards.utils.HtmlHelper.generateHtmlLinks

@Path("/licenses")
@Produces("text/plain")
class LicenseResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String = generateHtmlLinks("licenses",
        "get-by-hql-named-query-1",
        "get-by-hql-named-query-2",
        "get-by-sql-named-query"
    )

    @get:Path("get-by-hql-named-query-1")
    @get:GET
    val licenseUsingNamingQuery1: String? = JpqlQueries.getLicenseUsingNamingQuery()

    @get:Path("get-by-hql-named-query-2")
    @get:GET
    val licenseUsingNamingQuery2: String? = HqlQueries.getLicenseUsingNamingQuery()

    @get:Path("get-by-sql-named-query")
    @get:GET
    val licenseUsingNamingQuery3: String? = SqlQueries.licensesNamedQuery
}
