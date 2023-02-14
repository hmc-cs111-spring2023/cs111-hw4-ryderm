import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should._

class CollatzSpec extends AnyFunSuite with Matchers:

    test("1") {
        Collatz(1) should be (4)
    }

    test("2") {
        Collatz(2) should be (1)
    }

    test("3") {
        Collatz(3) should be (10)
    }

    test("8") {
        Collatz(8) should be (4)
    }

    test("9") {
        Collatz(9) should be (28)
    }
    
    test("0") {
        Collatz(0) should be (0)
    }


end CollatzSpec
