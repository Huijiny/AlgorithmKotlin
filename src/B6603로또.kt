fun main() {
    val br = System.`in`.bufferedReader()
    while (true) {
        var values = br.readLine().split(" ")
        if (values[0].equals("0")) break
        values = values.subList(1, values.size)
        recursive(1, values, 0, mutableListOf())
        println()
    }
}

fun recursive(count: Int, values: List<String>, index: Int, numbers: MutableList<String>) {
    if (count == 7) {
        numbers.forEach { print("$it ") }
        println()
        return
    } else {
        for (i in index..values.size-1) {
            val value = values[i]
            numbers.add(value) // 하나 넣고
            recursive(count+1, values, i+1, numbers) // 다음 recursive 돌려
            numbers.removeLast() // 마지막으로 한 애 지워
        }
    }
}