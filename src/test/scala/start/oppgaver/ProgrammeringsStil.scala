
package start.oppgaver

package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class ProgrammeringsStil extends Spec with ShouldMatchers {
  describe("Programmerings stil"){
    val liste = List(1,2,3,4,5,6,7,8,9,10)
    val summenAvListen = 55
    describe("Imperativ -- "){
      it("konkatiner alle elementene i listen"){
        var alle = ""

        // -- fyll inn

        alle should equal ("12345678910")
      }

      it("summere alle tallene i listen"){
        var sum = 0

        // -- fyll inn

        sum should be (summenAvListen)
      }


    }

    describe("Funksjonell -- "){
      it("skriv ut alle elementene i listen"){
        var alle = ""
        // i første forsøk, behold var
        // -- fyll inn

        alle should equal ("12345678910")
      }

      it("summere listen"){
        var sum = 0

        // i første forsøk behold var
        // -- fyll inn

        sum should be(summenAvListen)
      }
    }
  }
}