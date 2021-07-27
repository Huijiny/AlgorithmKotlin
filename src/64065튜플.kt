class `64065튜플` {
    fun solution(s: String): IntArray {
        var hashMap = hashMapOf<Long, Int>()
        var options = arrayListOf<Int>()
        s.substring(1, s.length-1)
            .split(',')
            .toList()
            .forEach {
                var tmp = it
                if ("{" in tmp) {
                    tmp = tmp.substring(1, tmp.length)
                }
                if ("}" in tmp) {
                    tmp = tmp.substring(0, tmp.length-1)
                }
                options.add(tmp.toInt())
            }
        for (option in options) {
            hashMap.put(option.toLong(), hashMap.getOrDefault(option.toLong(), 0)+1)
        }
        var sortedMap = hashMap.toList().sortedWith(compareBy({it.second})).toMap().keys.reversed()
        return  sortedMap.map { it.toString().toInt() }.toIntArray()

    }
    fun solution2(s: String): IntArray {
        return s.substring(2 until s.length-2)
            .split("},{")
            .asSequence()
            .map { it.split(",").map { num -> num.toInt() } }
            .toList()
            .sortedBy { it.size }
            .fold(setOf<Int>()) { acc, list -> acc.union(list) }
            .toIntArray()
    }
}
fun main() {
    `64065튜플`().solution("{{123}}")
}