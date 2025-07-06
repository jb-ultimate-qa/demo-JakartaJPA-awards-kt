package my.example.awards.utils

object HtmlHelper {

    fun generateHtmlLinks(path: String, vararg endpoints: String): String {
        val builder = StringBuilder()
        builder.append("Try this URL for $path:<br><br>\n")

        for (e in endpoints) {
            builder.append("""<a href="$path/$e">$path/$e</a><br>""")
            builder.append("\n")
        }
        return builder.toString()
    }

    fun generateHtmlLinksForHello(vararg endpoints: String): String {
        val builder = StringBuilder()
        builder.append("Try this URL:<br><br>\n")

        for (e in endpoints) {
            builder.append("""<a href="$e">$e</a><br>""")
            builder.append("\n")
        }
        return builder.toString()
    }

}