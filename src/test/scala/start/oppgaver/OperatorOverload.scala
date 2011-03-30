package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class OperatorOverload extends Spec with ShouldMatchers {
  describe("Operator overload -- +"){
     trait Vekt {
       val vekt: Int
     }

     class Henger(val vekt:Int) extends Vekt
     class LasteBil(val vekt:Int) extends Bil with Vekt{
       def +(henger:Henger) = vekt + henger.vekt
       def +:(henger: Henger) = vekt + henger.vekt
     }

     it("regn total vekt"){
       val bil = new LasteBil(4000)
       val henger = new Henger(3000)

       val totalvekt = henger +: bil


       totalvekt should be(7000)

     }

   }
}
