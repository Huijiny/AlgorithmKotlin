package codingTest

class toss_2 {
    // 이 함수는 수정하지 마세요.
    fun solution(data: Array<String>): Array<String> {
        return data.map {
            parse(it).toString()
        }.toTypedArray()
    }

    // 이 함수를 구현해주세요.
    fun parse(input: String): Uri {
        val (scheme, back) = input.split("://")
        val onlyEnglish = Regex("^[a-zA-Z]*\$")
        val regexForHost = Regex("^[a-zA-Z0-9.-.]*\$")
        val exp = Regex("^[a-zA-Z0-9._ -]\$")
        exp.matches(scheme)

        val (firstPart ,query) = back.split("?")
        val indexOfFirstSlash = firstPart.indexOf("/")
        val host = firstPart.substring(0, indexOfFirstSlash)
        val Query = firstPart.substring(indexOfFirstSlash)
        TODO()
    }
}

// 이 클래스는 수정하지 않아도 됩니다.
class Uri(private val scheme: String,
          private val host: String,
          private val path: String,
          private val query: Map<String, String?>) {

    override fun toString(): String {
        val queryBuilder = StringBuilder()
        queryBuilder.append("{")
        queryBuilder.append(query.entries.sortedBy {
            it.key
        }.joinToString { entry ->
            String.format("%s=%s", entry.key, entry.value)
        })
        queryBuilder.append("}")
        return "codingTest.Uri(scheme=%s, host=%s, path=%s, query=%s)".format(
            scheme,
            host,
            path,
            queryBuilder.toString()
        )
    }
}