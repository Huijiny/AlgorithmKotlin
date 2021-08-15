package codingTest

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class toss_1 {
    fun solution(date: String, requests: Array<String>): Int {
        var answer: Int = 0

        var creditcardDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"))
        requests.forEach { request ->
            var (name, birth) = request.split(',')
            var birthOfCustomer = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyyMMdd"))
            println(birthOfCustomer)
            var yearDiff = creditcardDate.minusYears(birthOfCustomer.year.toLong()).year
            println(yearDiff)
            println(birthOfCustomer.plusYears(yearDiff.toLong()))
            println(creditcardDate)
            if (birthOfCustomer.plusYears(yearDiff.toLong()).isAfter(creditcardDate) || birthOfCustomer.plusYears(yearDiff.toLong()).isEqual(creditcardDate)) {

                println(birthOfCustomer.plusYears(yearDiff.toLong()).isAfter(creditcardDate))
                answer += 1
            }
        }
        print(answer)
        return answer
    }
}
fun main() {
    toss_1().solution("20160803", arrayOf("dbgmlwls,19970803", "이토스,20020729"))
}