fun main() {
    val br = System.`in`.bufferedReader()
    val count = br.readLine().toInt()
    val list = mutableListOf<Pair<Int, String>>()
    repeat(count) {
        val (age, name) = br.readLine().split(" ")
        list.add(Pair(age.toInt(), name))
    }
    list.withIndex()
    list.sortWith(compareBy({ it.first }))
    list.forEach { println("${it.first} ${it.second}") }
}

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val count = br.readLine().toInt()
//    val list = Array(count) {
//        val (age, name) = br.readLine().split(" ")
//        Pair(age, name)
//    }
//    list.sortBy { it.first }
//    list.forEach { println("${it.first} ${it.second}") }
//}