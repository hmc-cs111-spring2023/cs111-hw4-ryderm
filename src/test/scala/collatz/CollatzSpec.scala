import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should._

class CollatzSpec extends AnyFunSuite with Matchers:

    test("collatz1") {
        collatz(1) should be (4)
    }

    test("collatz2") {
        collatz(2) should be (1)
    }

    test("collatz3") {
        collatz(3) should be (10)
    }

    test("collatz8") {
        collatz(8) should be (4)
    }

    test("collatz9") {
        collatz(9) should be (28)
    }

    test("collatz0") {
        collatz(0) should be (0)
    }

    test("collatzCount1") {
        collatzCount(1) should be (0)
    }

    test("collatzCount3") {
        collatzCount(3) should be (7)
    }

    test("collatzCount2") {
        collatzCount(2) should be (1)
    }

    test("collatzCount101") {
        collatzCount(101) should be (25)
    }


end CollatzSpec
