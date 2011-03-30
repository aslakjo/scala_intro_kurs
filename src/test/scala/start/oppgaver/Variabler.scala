package start.oppgaver
package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Variabler extends Spec with ShouldMatchers {
  describe("Variabler"){

    it ("definere en string variabel"){
      val enStreng = 2 // -- fyll inn
      enStreng.isInstanceOf[String] should be (true)
    }

    it ("definer en variabel som kan endre seg"){
      // -- fyll inn
      //sum should be (0)

      //sum = 10
      //sum should be (10)
      fail
    }

  }
}