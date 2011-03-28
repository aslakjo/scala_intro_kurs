package scala.start

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import model._

class Oppgaver extends Spec with ShouldMatchers {

  describe ("Oppgaver"){
    describe("Variabler"){

      it ("definere en string variabel"){
        val enStreng = "Streng"

        enStreng.isInstanceOf[String] should be (true)
      }

      it ("definer en variabel som kan endre seg"){
        var sum = 0

        sum should be (0)

        for(i <- 1 to 10) {
          sum = sum + 1
        }

        sum should be (10)
      }

    }

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

      describe("Multiple arv -- traits"){
        type BilMedKran = {
          def harKran:Boolean
        }

        it("Lag en bil, altså kjøretøy med 4 hjul -- arv"){
          val bil:Kjøretøy = new Bil()

          bil.antallHjul should be (4)
        }


        it("Lag en kran bil, en bil med en kran -- mixin"){
          trait Kran{
            def harKran = true
          }

          val kranBil = new Bil with Kran

          kranBil should be('harKran)
        }

        it("Lag en bil med disel motor -- overskrive egenskaper"){
          trait Disel extends Kjøretøy{
            override def motor ="Disel"
          }

          val bil = new Bil with Disel

          bil.motor should be("Disel")
        }
      }


      describe("Operator overload -- +"){
        trait Vekt {
          val vekt: Int
        }

        class Henger(val vekt:Int) extends Vekt
        class LasteBil(val vekt:Int) extends Bil with Vekt{
          def +(henger:Henger) = vekt + henger.vekt
        }

        it("regn total vekt"){
          val bil = new LasteBil(4000)
          val henger = new Henger(3000)

          val totalvekt = bil + henger

          totalvekt should be(7000)
        }

      }

      describe("Utvidbart"){
        case class Hjul(val navn:String, val tilstand:Int)

        class Bil{
          val hjulSett = List(høyreForand, venstreForand, høyreBak, venstreBak)
          def høyreForand = new Hjul("høyre foran", 60)
          def venstreForand = new Hjul("venstre foran", 60)
          def høyreBak = new Hjul("høyre bak", 30)
          def venstreBak = new Hjul("venstre bak", 40)

          def apply(hjul:String):Hjul = hjulSett.find(_.navn == hjul) get
        }


        val liste = List("første", "andre", "tredje")
        it("Hent ut første elementet i listen"){
          val første = liste(0)

          første should be ("første")
        }

        it("hent ut høyre for hjul -- implementere apply"){
          val bil = new Bil

          bil("høyre foran") should have {
            'navn ("høyre foran")
          }

        }
      }
    }
  }

}