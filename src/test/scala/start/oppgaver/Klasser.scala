package start.oppgaver

package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Klasser extends Spec with ShouldMatchers {
  describe("Klasser"){
    it("definer en person klasse med navn og alder"){
      type NavnOgAlder = {val fornavn:String; val alder:Int}

      val person:NavnOgAlder = null // -- fyll inn

      person.fornavn should be ("aslak")
      person.alder should be (27)
    }

    describe ("Metoder") {
      it("Legg til etternavn og sett sammen for og etter-navn"){
        val person = // -- fyll inn

        //person.fulltNavn should be ("ole aleksander filibombombom")
        fail
      }
    }
  }
}