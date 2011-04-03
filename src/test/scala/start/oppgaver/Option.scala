package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class OptionOppgaver extends Spec with ShouldMatchers {
  describe("Option") {
    val team = List("Egon", "Benny", "Kjell")
    it("skal returnere at vi ikke har det elementet"){
      def teamMedlem(navn:String) ={
        team.find(_ == navn)
      }
      val element = teamMedlem("Anders")

      element match {
        case None => "pass"
        case _ => fail
      }
    }

    it("skal returnere (ingen) eller navnet på medlemen"){
      val benny = Some("Benny")
      val valborg = None

      def navnPåMedlem(medlem : Option[String]) = medlem getOrElse "(ingen)"

      navnPåMedlem(benny) should be("Benny")
      navnPåMedlem(valborg) should be("(ingen)")
    }
  }
}