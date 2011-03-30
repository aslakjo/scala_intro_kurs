package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Traits extends Spec with ShouldMatchers {
  describe("Multiple arv -- traits"){

    abstract class Kjøretøy(val antallHjul:Int){

    }

    it("Lag en bil, altså kjøretøy med 4 hjul -- arv"){
      val bil:Kjøretøy = null // -- fyll inn

      bil.antallHjul should be (4)
    }


    it("Lag en kran bil, en bil med en kran -- mixin"){
      val kranBil = "" // -- fyll inn

      kranBil should be('harKran)
    }

    it("Lag en bil med disel motor -- overskrive egenskaper"){
      val bil = ""

      // -- fyll inn  

      //bil.motor should be("Disel")
      fail
    }
  }
}