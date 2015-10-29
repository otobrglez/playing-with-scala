object Tut001 {
  def main(args: Array[String]): Unit = {
    assert(1 == 1)

    case class Person(ime: String)

    val me = Person("Oto")
    val you = Person("Miha")

    val people = List(me, you)
    assert(people.length == 2)
  }
}
