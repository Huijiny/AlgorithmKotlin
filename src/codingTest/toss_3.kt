package codingTest

// Solution class 는 수정하면 안됩니다.
class toss_3 {
    fun solution(N: Int, M: Long): Long {
        var answer: Long = 0

        var foo: Foo = PlusOne()
        var tenMultiplier = TenMultiplier(foo)

        answer += sum(N, M, foo)
        answer += sum(N, M, tenMultiplier)

        foo = PlusTwo()
        tenMultiplier = TenMultiplier(foo)
        answer += sum(N, M, foo)
        answer += sum(N, M, tenMultiplier)

        foo = PlusThree()
        tenMultiplier = TenMultiplier(foo)
        answer += sum(N, M, foo)
        answer += sum(N, M, tenMultiplier)

        return answer
    }
}

interface Foo {
    fun foo(i: Int): Int
    fun foo(l: Long): Long
}


/**
 * codingTest.Foo 의 구현체
 * 인자로 넘어온 값에 +1
 *
 * TODO 유실됨
 */
class PlusOne: Foo {
    override fun foo(i: Int): Int {
        return i+1
    }

    override fun foo(l: Long): Long {
        return l+1
    }

}


/**
 * codingTest.Foo 의 구현체
 * 인자로 넘어온 값에 +2
 *
 * TODO 유실됨
 */
class PlusTwo: Foo {
    override fun foo(i: Int): Int {
        return i+2
    }

    override fun foo(l: Long): Long {
        return l+2
    }

}


/**
 * codingTest.Foo 의 구현체
 * 인자로 넘어온 값에 + 3
 *
 * TODO 유실됨
 */
class PlusThree: Foo {
    override fun foo(i: Int): Int {
        return i+3
    }

    override fun foo(l: Long): Long {
        return l+3
    }

}



/**
 * codingTest.Foo 의 구현체
 * 넘어온 foo 의 foo 함수 호출 결과를 * 10 을 한다
 *
 * TODO 유실됨
 */
class TenMultiplier(private val foo: Foo): Foo {
    override fun foo(i: Int): Int {
        return foo.foo(i) * 10
    }

    override fun foo(l: Long): Long {
        return foo.foo(l) * 10
    }

}


/**
 *
 * 각각의 인자들을 받아서 codingTest.Foo 인터페이스의 내부 함수들의 반환값들을 덧셈하는 함수
 *
 * @param i codingTest.Foo 의 foo(i: Int) 에 인자
 * @param l codingTest.Foo 의 foo(l: Long) 에 인자
 * @param foo codingTest.Foo
 */
fun sum(i: Int, l: Long, foo: Foo): Long = foo.foo(i) + foo.foo(l)