import org.scalatest._
import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

class MoreScalaSpec extends FlatSpec {

  it should "do this" in {
    val words = "kitchen thicken the ababab testing bababa".split(" ").toList

    val pom = words.filter(_.length > 4).map {
      (word) => List(word, words.map(_.toLowerCase).map(_.sorted).filter((w) => {
        word.toList.sorted.mkString("") == w
      }))
    }
  }

  it should "understand Option" in {
    case class Person(val name: String, var age: Option[Int] = None)
    val p1 = Person("Oto")
    val p2: Option[Person] = Option(Person("Martina"))

    p1.age = Option(28)
    assert(p1.age.map(_ + 10).getOrElse(0) == 38)
  }
}

