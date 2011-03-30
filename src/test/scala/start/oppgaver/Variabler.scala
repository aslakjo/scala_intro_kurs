package start.oppgaver
package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Variabler extends Spec with ShouldMatchers {
  describe("Variabler"){

    it ("definere en string variabel"){
      val enStreng = "treng"
      enStreng.isInstanceOf[String] should be (true)
    }

    it ("definer en variabel som kan endre seg"){
      var sum = 0
      sum should be (0)

      sum = 10

      sum should be (10)
    }

  }
}