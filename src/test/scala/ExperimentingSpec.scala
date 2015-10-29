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
    // object = singelton
    object Pozdrav {
      def english = "Hi"

      def slovenian = "Pozdrav"
    }

    assert(Pozdrav.english == "Hi")

    val x = Pozdrav
    val y = x

    println(x)
    println(y)
  }

  it should "object + class" in {
    class Person(val name: String, val country: String)

    object Person {
      def build(name: String, country: String) = {
        country match {
          case "slovenia" => Some(new Person(name, "Slovenian"))
          case _ => Some(new Person(name, country))
        }
      }
    }

    val me = Person.build("Oto", "slovenia")
    assert(me.get.country == "Slovenian")
  }

  it should "class II" in {
    class SecretAgent(val name: String) {
      def shoot(n: Int) {
        SecretAgent.decrementBullets(n)
      }
    }

    object SecretAgent {
      //This is encapsulated!
      var bullets: Int = 3000

      private def decrementBullets(count: Int) {
        if (bullets - count <= 0) bullets = 0
        else bullets = bullets - count
      }
    }

    val bond = new SecretAgent("James Bond")
    val felix = new SecretAgent("Felix Leitner")
    val jason = new SecretAgent("Jason Bourne")
    val _99 = new SecretAgent("99")
    val max = new SecretAgent("Max Smart")

    bond.shoot(800)
    felix.shoot(200)
    jason.shoot(150)
    _99.shoot(150)
    max.shoot(200)

    assert(SecretAgent.bullets == 1500)
  }

  it should "class III" in {
    class Person (val name:String,  private val superheroName:String)  //The superhero name is private!

    object Person {
      def showMeInnerSecret(x:Person) = x.superheroName
    }

    val clark = new Person("Clark Kent", "Superman")
    val peter = new Person("Peter Parker", "Spiderman")
    val bruce = new Person("Bruce Wayne", "Batman")
    val diana = new Person("Diana Prince", "Wonder Woman")

    assert(Person.showMeInnerSecret(clark) == "Superman")
  }
}

