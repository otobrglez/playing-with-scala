import org.scalatest.FlatSpec

class TutHLFunctionsSpec extends FlatSpec {

  it should "have functions" in {
    assert(1 == 1)

    def addOne = { x: Int => x + 1 }
    def reduceTwo = (x: Int) => x - 2
    def sumTwo = (x: Int, y: Int) => x + y

    def myName = new Function[Int, Int] {
      def apply(v1: Int): Int = v1 + 1
    }

    assert(addOne(100) == 101)
    assert(reduceTwo(102) == 100)
    assert(sumTwo(50, 50) == 100)

    assert(myName(4) == 5)
  }

  it should "have closures" in {
    var incrementer = 1

    def closure = {
      x: Int => x + incrementer
    }

    assert(closure(10) == 11)

    incrementer += 1

    assert(closure(10) == 12)
  }

  it should "return function" in {
    def buildFunction(x: Int) = {
      new Function[Int, Int] {
        def apply(y: Int): Int = x + y
      }
    }

    assert(buildFunction(10)(10) == 20)
    assert(buildFunction(10).isInstanceOf[Function1[Int, Int]])
  }

}
