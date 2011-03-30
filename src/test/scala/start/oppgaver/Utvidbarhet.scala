package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Utvidbarhet extends Spec with ShouldMatchers {

  describe("Utvidbart"){
    it("Hent ut første elementet i listen"){
      val liste = List("første", "andre", "tredje")
      val første = liste(0)

      første should be ("første")
    }


    class EnIndexertListe(moderListe:List[String]){
      def apply(i : Int) = moderListe(i-1)
    }

    it("Implementer en egen 1 indexert liste -- implementere apply"){
      val egenListe = new EnIndexertListe(List("en", "to", "tre"))

      egenListe(2) should be ("to")
    }
  }
}
