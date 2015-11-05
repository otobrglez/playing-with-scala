import scala.util.{Success, Failure}
import org.scalatest.FlatSpec
import dispatch._, Defaults._

import scala.concurrent.Promise

class DispatchSpec extends FlatSpec {

  it should "do dispatch" in {
    val response: Future[String] = Http.configure(_ setFollowRedirects true)(url("http://icanhazptr.com/") OK as.String)
    response onComplete {
      case Success(content) => assert(content.length > 3)
      case Failure(content) => println(content.getMessage)
    }
  }
}
