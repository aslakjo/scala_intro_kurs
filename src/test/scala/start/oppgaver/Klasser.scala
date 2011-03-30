package start.oppgaver

package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Klasser extends Spec with ShouldMatchers {
  describe("Klasser"){
    class Person(val fornavn :String , val alder:Int)

    it("definer en person klasse med navn og alder"){
      type NavnOgAlder = {val fornavn:String; val alder:Int}

      val person:NavnOgAlder = new Person("aslak", 27)

      person.fornavn should be ("aslak")
      person.alder should be (27)
      
    }

    describe ("Metoder") {
      it("Sett sammen for og etter-navn"){
        val person = null
        // -- fyll inn

        //person.fulltNavn should be ("ole aleksander filibombombom")
      
      }
    }
  }
}