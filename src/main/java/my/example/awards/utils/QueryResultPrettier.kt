package my.example.awards.utils

object QueryResultPrettier {
    fun <T> concatenateObjects(objects: List<T?>): String {
        if (objects.isEmpty()) return ""

        val result = StringBuilder()
        for (item in objects) {
            result.append(item.toString())
            result.append("\n")
        }
        return result.toString()
    }

    fun <T> printObjects(objects: List<T?>) {
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        if (objects.isEmpty()) println("~~~nothing~~~")
        else for (item in objects) {
            println(item.toString())
        }
    }
}
