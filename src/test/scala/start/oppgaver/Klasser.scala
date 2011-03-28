package start.oppgaver

package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Klasser extends Spec with ShouldMatchers {
  describe("Klasser"){
    case class Person(fornavn:String,
                      etternavn:String,
                      alder:Int
                     ){
      def fulltNavn = "%s %s".format(fornavn, etternavn)
    }

    it("definer en person klasse med navn og alder"){
      type NavnOgAlder = {val fornavn:String; val alder:Int}

      val person:NavnOgAlder = new Person("aslak", "jo", 27)

      person.fornavn should be ("aslak")
      person.alder should be (27)
    }

    describe ("Metoder") {
      it("Sett sammen for og etternavn"){
        val person = new Person("ole aleksander", "filibombombom", 4)

        person.fulltNavn should be ("ole aleksander filibombombom")
      }
    }
  }
}