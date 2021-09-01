fun main() {
    val br = System.`in`.bufferedReader()
    val vertex = br.readLine().toInt()

    val left = Array(vertex+1) { "." }
    val right = Array(vertex+1) { "." }

    val nodes = Array(vertex+1) { "." }

//    val code = mapOf<String, Int>

    for (i in 1..vertex+1) {
        val values = br.readLine().split(" ")
        nodes[i] = values.get(0)
        left[i] = values.get(1)
        right[i] = values.get(2)
    }
}