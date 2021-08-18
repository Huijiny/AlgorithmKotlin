fun main() {
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()
    var values = mutableListOf<Pair<Int, Int>>()

    repeat(tc) { i ->
        val (first, second) = br.readLine().split(" ")
        values.add(Pair(first.toInt(), second.toInt()))
    }
    values.sortWith(compareBy ({ it.second }, { it.first }))
    values.forEach { println("${it.first} ${it.second}") }
}