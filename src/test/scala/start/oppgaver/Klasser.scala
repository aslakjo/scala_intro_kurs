package start.oppgaver

package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Klasser extends Spec with ShouldMatchers {
  describe("Klasser"){
    class Person(val fornavn :String, val etternavn:String , val alder:Int){
      def fulltNavn = fornavn +" "+ etternavn
    }


    it("definer en person klasse med navn og alder"){
      type NavnOgAlder = {val fornavn:String; val alder:Int}

      val person:NavnOgAlder = new Person("aslak", "jo", 27)

      person.fornavn should be ("aslak")
      person.alder should be (27)
      
    }

    describe ("Metoder") {
      it("Legg til etternavn og sett sammen for og etter-navn"){
        val person = new Person("ole aleksander", "filibombombom", 10)

        person.fulltNavn should be ("ole aleksander filibombombom")
      }
    }
  }
}