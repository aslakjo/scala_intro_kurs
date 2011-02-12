import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class Oppgaver extends Spec with ShouldMatchers {


  describe("Oppgaver - ") {

    val tallFra1Til10 = Range(1, 10)

    describe("oppgave 1 - looping ") {

      it("deklarativt") {
        var i = 0

        //loop over tallFra1Til10 med en for løkke

        i should be(10)
      }

      it("imperativt") {

        val i = 0 //loop over tallFra1Til10 imperativt

        i should be(10)
      }

    }

    describe("oppgave 2 - jobbe med lister") {

      it("lag en liste") {
        val liste = Nil

        liste should not be ('empty)
      }

      it("\"legg\" til et element") {

        var liste = EksempelData.liste1

        //legg til ett element i lista som inneholder tre elementer
        val resultatListe = Nil

        resultatListe.size should be(4)
      }

      it("konkatinasjon") {
        val liste1 = EksempelData.liste1
        val liste2 = EksempelData.liste2

        //konkatiner listene
        val resultatListe = Nil

        resultatListe.mkString(",") should be("1,2,3,4,5,6")
        liste1.mkString(",") should be("1,2,3")
      }

      it("gang hvert element med 2") {
        val tall = EksempelData.tallFraEnTilFem

        val dobleTall = Nil //Hint: map(_)

        dobleTall.mkString(",") should be("2,4,6,8,10")
      }

      it("finn alle oddetal") {
        val tall = EksempelData.tallFraEnTilFem

        val oddeTall = Nil

        oddeTall.mkString(",") should be("1,3,5")
      }
    }


    describe("oppgave 3 - tupler") {

      it("lag en tuple med to verdier") {
        var tuple:Tuple2[Int, Int] = null

        val forsteVerdi = 1
        val andreVerdi = 2

        tuple._1 should be(1)
        tuple._2 should be(2)
      }

      it("skal returnere to verdier fra en funksjon"){
        def multipleReturn:Tuple2[Int, Int] = null

        val en, to = multipleReturn


        en should be (1)
        to should be (2)
      }

      it("populer en HashMap ved hjelp av tupler ") {
        import scala.collection.mutable.HashMap
        val map = new HashMap[String, Int]()

        //legg til de manglende elementer

        map("en") should be (1)
        map("to") should be (2)
      }

      it("populer en imutable Map ved hjelp av tupler ") {
        val map = Map[String, Int]()//fyll på med elementer

        map("tre") should be (3)
        map("fire") should be (4)
      }

    }

    describe ("oppgave 4 - case classes") {
      it ("lag en person") {
        val person = null

        person_har_navn_og_alder(person)

        def person_har_navn_og_alder(person: {val navn:String; val alder:Int})={
          person should not be (null)
          person.navn should not be ('empty)
          person.alder should be > 0
        }
      }

      it ("implementer person slik at to med likt navn og alder er identiske(equals)") {
        val person1:AnyRef = null
        val person2:AnyRef = ""

        person1 should equal(person2)
      }

      it ("implement person slik at hash code er ihenhold til java standard")  {
        val person1:AnyRef = null
        val person2:AnyRef = ""

        person1.hashCode should equal(person2.hashCode)
      }

      it ("kopier en person inn i en annen variabel") {
        val person1:navnOgAlder = null
        val person2:navnOgAlder = null

        person1 should not be theSameInstanceAs(person2)

        skal_ha_samme_navn_og_alder(person1, person2)


        type navnOgAlder = {val navn:String; val alder:Int}

        def skal_ha_samme_navn_og_alder(a:navnOgAlder, b:navnOgAlder)={
          a.navn should equal(b.navn)
          a.alder should equal(b.alder)
        }
      }

      describe ("oppgave 5 - pattern matching") {
        it ("Finn blomster over 20 cm") {
          val hoyeBlomster = EksempelData.blomster
          hoyeBlomster.foreach(_.hoyde should be > (20))
        }

        it ("Finn alle pene blomster(som har som superclasse)") {
          val peneBlomster:List[Blomst] = EksempelData.blomster

          peneBlomster.size should be (2)
          peneBlomster should not contain(Blomst("Løvetan", 8, Utseende(Farge("Gul"))))
        }

        it ("Hent fargen på blomsten") {
          val farger:List[String] = null//EksempelData.blomster.map

          farger should be (List("Rød", "Blå", "Gul"))
        }

      }

    }

  }
}
