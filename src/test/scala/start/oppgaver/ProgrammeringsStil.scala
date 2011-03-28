
package start.oppgaver

package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class ProgrammeringsStil extends Spec with ShouldMatchers {
  describe("Programmerings stil"){
    val liste = List(1,2,3,4,5,6,7,8,9,10)
    val summenAvListen = 55
    describe("Imperativ"){
      it("skriv ut alle elementene i listen"){
        var alle = ""

        for(i <- liste){
          alle += i
        }

        alle should equal ("12345678910")
      }

      it("summere listen"){
        var sum = 0

        for(i <- liste)
        {
          sum = sum + i
        }

        sum should be (summenAvListen)
      }


    }

    describe("funksjonell"){
      it("skriv ut alle elementene i listen"){

        //Løsnning en
        var alle = ""
        liste.foreach((s:Int) => alle += s)

        //Løsnning to
        alle = liste.foldLeft("")((teksten, neste) => teksten + neste)

        alle should equal ("12345678910")
      }

      it("summere listen"){

        //Løsning en.
        var sum = 0
        liste.foreach((i:Int) => sum = sum + i )

        //Løsning to, vanskligere å forstå.
        sum = 0
        sum = liste.foldLeft(0)((summen:Int, next:Int) => summen + next)

        sum should be(summenAvListen)
      }
    }
  }
}