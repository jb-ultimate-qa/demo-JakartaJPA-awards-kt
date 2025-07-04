package my.example.awards.endpoints

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import my.example.awards.queries.HqlQueries
import my.example.awards.queries.JpqlQueries
import my.example.awards.queries.SqlQueries

@Path("/licenses")
@Produces("text/plain")
class LicenseResource {
    @get:Path("/")
    @get:Produces("text/html")
    @get:GET
    val links: String
        get() = """Try this URL:</br></br>
        |<a href="licenses/get-by-hql-named-query-1">awards/get-by-hql-named-query-1</a></br>
        |<a href="licenses/get-by-hql-named-query-2">awards/get-by-hql-named-query-2</a></br>
        |<a href="licenses/get-by-sql-named-query">awards/get-by-sql-named-query</a>""".trimMargin()

    @get:Path("get-by-hql-named-query-1")
    @get:GET
    val licenseUsingNamingQuery1: String?
        get() {
            val jpqlQueries = JpqlQueries()
            return jpqlQueries.getLicenseUsingNamingQuery()
        }

    @get:Path("get-by-hql-named-query-2")
    @get:GET
    val licenseUsingNamingQuery2: String?
        get() {
            val hqlQueries = HqlQueries()
            return hqlQueries.getLicenseUsingNamingQuery()
        }

    @get:Path("get-by-sql-named-query")
    @get:GET
    val awardsAfter2022: String?
        get() {
            val sqlQueries = SqlQueries()
            return sqlQueries.licensesNamedQuery
        }
}
