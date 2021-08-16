fun main() {
    val br = System.`in`.bufferedReader()
    val croatidaAlphas = arrayListOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var word = br.readLine()
    croatidaAlphas.forEach { alphabet ->
        while (word.contains(alphabet)) {
            word = word.replace(alphabet, "0")

        }
    }
    println(word.count())
}