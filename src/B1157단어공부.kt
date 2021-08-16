fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine().toString().uppercase()
    val alphabets = str.toList().distinct()
    val counts = IntArray(alphabets.size) { i -> 0 }
    alphabets.forEachIndexed { idx, alphabet ->
        str.forEach { s ->
            if (alphabet.equals(s)) {
                counts[idx] += 1
            }
        }
    }
    var max = 0
    var maxCount = 0
    var value = ""
    counts.forEach { count ->
        if (max < count) {
            max = count
        }
    }
    counts.forEachIndexed { idx, count ->
        if (count == max) {
            maxCount += 1
            value = alphabets[idx].toString()
        }
    }
    if (maxCount > 1) {
        println("?")
    } else {
        println(value)
    }

}