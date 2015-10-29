import org.scalatest.FlatSpec

class ExperimentingSpec extends FlatSpec {
  it should "do assertion" in {
    assert(1 === 1)

    val ime = "Oto"
    val ime2 = "Martina"
    // ime2 = "Oto" <- val = immutable
    assert(ime !== ime2)
  }

  it should "do classes" in {
    class Point(xc: Int, xy: Int) {
      var x: Int = xc
      var y: Int = xy

      def move(dx: Int, dy: Int) {
        x = x + dx
        y = y + dy
      }

      override def toString(): String = "(" + x + "," + y + ")"
    }

    val a = new Point(10, 4)
    a.move(2, 2)
    assert(a.x == 12)
    assert(a.y == 6)

    assert(a.toString() == "(12,6)")
    println(a)
  }

  it should "options" in {
    val name: Option[String] = Some("No idea")
    assert(name.get == "No idea")

    val a: Option[String] = None
    assert(a == None)

    def callMe(name: String): Option[String] = {
      if (name != None) Some(name) else None
    }

    assert(callMe("Oto") == Some("Oto"))


    def who(name: Option[String] = None): String = {
      name match {
        case Some(v) => v
        case None => "No-one"
      }
    }

    assert(who() == "No-one")
    assert(who(Some("Oto")) == "Oto")
  }

  it should "objects" in {
    object Pozdrav {
      def english = "Hi"
      def slovenian = "Pozdrav"
    }

    assert(Pozdrav.english == "Hi")
  }
}

