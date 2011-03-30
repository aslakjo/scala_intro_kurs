package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Traits extends Spec with ShouldMatchers {
  describe("Multiple arv -- traits"){
    type BilMedKran = {
      def harKran:Boolean
    }

    it("Lag en bil, altså kjøretøy med 4 hjul -- arv"){
      val bil:Kjøretøy = new Bil()

      bil.antallHjul should be (4)
    }


    it("Lag en kran bil, en bil med en kran -- mixin"){
      trait Kran{
        def harKran = true
      }

      val kranBil = new Bil with Kran

      kranBil should be('harKran)
    }

    it("Lag en bil med disel motor -- overskrive egenskaper"){
      trait Disel extends Kjøretøy{
        override def motor ="Disel"
      }

      val bil = new Bil with Disel

      bil.motor should be("Disel")
    }
  }
}