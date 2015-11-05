import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer


class PlayinWithListsSpec extends FlatSpec {

  it should "compute some matrices" in {
    assert(1 == 1)

    case class Element(value: Int)

    class Matrix {
      var elements: ListBuffer[Element] = new ListBuffer[Element]()

      def Matrix() = {
      }

      def add(element: Element) = {
        elements += element
      }
    }

    var m = new Matrix()
    m.add(new Element(100))
    assert(m.elements.length == 1)
  }

  it should "also work with lists" in {
    val text = "Krasna si, bistra hči planin,\nBrdka v prirodni si lepoti,\nko ti prozornih globočin\nnevihte temne srd ne moti —\nkrasna si, hči planin!"
    val words: Array[String] = text.split(' ')
  }
}
