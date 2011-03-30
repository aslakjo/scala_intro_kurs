package start.oppgaver

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class OperatorOverload extends Spec with ShouldMatchers {
  describe("Operator overload -- +"){

     class Henger(val vekt:Int)
     class LasteBil(val vekt:Int) 

     it("regn total vekt på bil pluss henger"){
       val bil = new LasteBil(4000)
       val henger = new Henger(3000)

       val totalvekt:Int = 0 //henger + bil  -- fyll inn

       totalvekt should be(7000)
     }

   }
}
