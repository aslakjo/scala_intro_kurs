package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Utvidbarhet extends Spec with ShouldMatchers {

  describe("Utvidbart"){
    case class Hjul(val navn:String, val tilstand:Int)

    class Bil{
      val hjulSett = List(høyreForand, venstreForand, høyreBak, venstreBak)
      def høyreForand = new Hjul("høyre foran", 60)
      def venstreForand = new Hjul("venstre foran", 60)
      def høyreBak = new Hjul("høyre bak", 30)
      def venstreBak = new Hjul("venstre bak", 40)

      def apply(hjul:String):Hjul = hjulSett.find(_.navn == hjul) get
    }


    val liste = List("første", "andre", "tredje")
    it("Hent ut første elementet i listen"){
      val første = liste(0)

      første should be ("første")
    }

    it("hent ut høyre for hjul -- implementere apply"){
      val bil = new Bil

      bil("høyre foran") should have {
        'navn ("høyre foran")
      }

    }
  }
}
