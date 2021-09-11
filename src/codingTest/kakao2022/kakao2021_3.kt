package codingTest.kakao2022

import java.util.*
import kotlin.math.ceil

class kakao2021_3 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var parkingTimePerCar = mutableMapOf<String, Int>()
        var INOUTCheckTable = mutableMapOf<String, List<String>>()

        records.forEach { record ->
            val (time, carNumber, inout) = record.split(" ")
            INOUTCheckTable.put(carNumber, INOUTCheckTable.getOrDefault(carNumber, emptyList()).plus(time))
        }

        INOUTCheckTable.forEach { key, value ->
            var tmpValue = value
            if (tmpValue.size % 2 == 1) {
                tmpValue = tmpValue.plus("23:59")
            }
            println(tmpValue)
            var cumTime = 0
            for (i in 0..tmpValue.size-1 step 2) {
                cumTime += getParkingTime(tmpValue[i], tmpValue[i+1])
            }
            parkingTimePerCar.put(key, calculateFee(cumTime, fees))
        }

        return parkingTimePerCar.toSortedMap().values.toIntArray()
    }

    private fun getParkingTime(from: String, to: String): Int {
        val fromTimeMillis = Calendar.getInstance().apply {
            val (h, m) = from.split(":")
            set(Calendar.HOUR, h.toInt())
            set(Calendar.MINUTE, m.toInt())
            set(Calendar.SECOND, 0)
        }.timeInMillis

        val toDayTimeMillis = Calendar.getInstance().apply {
            val (h, m) = to.split(":")
            set(Calendar.HOUR, h.toInt())
            set(Calendar.MINUTE, m.toInt())
            set(Calendar.SECOND, 0)
        }.timeInMillis

        val timeDiff = ((toDayTimeMillis - fromTimeMillis) / 1000) / 60
        return timeDiff.toInt()
    }

    private fun calculateFee(time: Int, fees: IntArray): Int {
        val (baseTime, baseFee, unitTime, unitFee) = fees
        if (time <= baseTime) {
            return baseFee
        }
        val restTime = time.toDouble() - baseTime.toDouble()
        val timePerUnit = ceil(restTime / unitTime)
        val fee = (timePerUnit * unitFee).toInt() + baseFee
        return fee
    }
}

fun main() {
    kakao2021_3().solution(intArrayOf(1, 461, 1, 10), arrayOf("00:00 1234 IN"))
}