class `42839소수찾기` {
    var countSet = mutableSetOf<String>()
    fun solution(numbers: String): Int {
        var answer = 0
        val numberList = numbers.split("")
            .toMutableList().subList(1, numbers.length+1)
        for (i in 0..numberList.size-1) {
            val tmp = numberList[i]
            if (tmp.toInt() == 0) {
                continue
            }
            numberList.removeAt(i)
            find(numberList, i, tmp)
            numberList.add(i, tmp)
        }
        return countSet.size
    }
    fun find(numberList: MutableList<String>, index: Int, s: String) {
        if (s.toLong().isPrime()) {
            countSet.add(s)
        }
        if (numberList.size == 0) {
            return
        }
        for (i in 0..numberList.size-1) {
            val tmp = numberList[i]
            numberList.removeAt(i)
            find(numberList, i, s+tmp)
            numberList.add(i, tmp)
        }
        return
    }
    fun Long.isPrime(): Boolean {
        var num = this
        if (num.toInt() == 1) return false
        for (i in (2 .. num.toInt()-1)) {
            if (num.toInt() % i == 0) return false
        }
        return true
    }
}

fun main() {
    `42839소수찾기`().solution("17")
}