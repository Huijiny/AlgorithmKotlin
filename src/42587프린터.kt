
class `42587프린터` {
    fun solution(priorities: IntArray, location: Int): Int {
        var printQueue = priorities.withIndex().toMutableList()
        var count = 0
        while (printQueue.isNotEmpty()) {
            val current: IndexedValue<Int> = printQueue.first()
            printQueue.removeAt(0)
            if(printQueue.any { current.value < it.value }) {
                printQueue.add(current)
                continue
            }
            count += 1
            if (location == current.index) {
                break
            }
        }
        return count
    }

}
fun main() {
    print(`42587프린터`().solution(intArrayOf(1, 1, 9, 1, 1, 1), 0))
}