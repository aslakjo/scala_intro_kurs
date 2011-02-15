import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class Oppgaver extends Spec with ShouldMatchers {


  describe("Oppgaver - ") {

    val tallFra1Til10 = Range(1, 11)

    describe("oppgave 1 - looping ") {

      it("imperativt") {
        var i = 0
        for(y <- tallFra1Til10) {
          i = y
        }

        i should be(10)
      }

      it("funksjonelt") {

        var i = 0

        tallFra1Til10.foreach(i=_)

        i should be(10)
      }

    }

    describe("oppgave 2 - jobbe med lister") {

      it("lag en liste") {
        val liste = List(1)

        liste should not be ('empty)
      }

      it("\"legg\" til et element") {

        var liste = EksempelData.liste1


        val resultatListe = 1 :: liste

        resultatListe.size should be(4)
      }

      it("konkatinasjon") {
        val liste1 = EksempelData.liste1
        val liste2 = EksempelData.liste2

        //konkatiner listene
        val resultatListe = liste1 ::: liste2

        resultatListe.mkString(",") should be("1,2,3,4,5,6")
        liste1.mkString(",") should be("1,2,3")
      }

      it("gang hvert element med 2") {
        val tall = EksempelData.tallFraEnTilFem

        val dobleTall = tall.map(x => x * 2)

        dobleTall.mkString(",") should be("2,4,6,8,10")
      }

      it("finn alle oddetal") {
        val tall = EksempelData.tallFraEnTilFem

        val oddeTall = tall.filter(_ % 2 == 1)

        oddeTall.mkString(",") should be("1,3,5")
      }
    }


    describe("oppgave 3 - tupler") {

      it("lag en tuple med to verdier") {
        var tuple: Tuple2[Int, Int] = null

        val forsteVerdi = 1
        val andreVerdi = 2

        tuple = (forsteVerdi, andreVerdi)

        tuple._1 should be(1)
        tuple._2 should be(2)
      }

      it("skal returnere to verdier fra en funksjon") {
        def multipleReturn: Tuple2[Int, Int] = (1,2)

        val (en, to) = multipleReturn

        en should be(1)
        to should be(2)
      }

      it("populer en HashMap ved hjelp av tupler ") {
        import scala.collection.mutable.HashMap
        val map = new HashMap[String, Int]()

        map += ("en" -> 1)
        map.put("to", 2)

        map("en") should be(1)
        map("to") should be(2)
      }

      it("populer en imutable Map ved hjelp av tupler ") {
        val map = Map[String, Int]() + ("tre" -> 3) + ("fire" -> 4)

        map("tre") should be(3)
        map("fire") should be(4)
      }

    }

    describe("oppgave 4 - case classes") {

      case class Person(navn: String, alder: Int)
      it("lag en person") {
        val person = Person("Torbjørn", 32)

        person_har_navn_og_alder(person)

        def person_har_navn_og_alder(person: {val navn: String; val alder: Int}) = {
          person should not be (null)
          person.navn should not be ('empty)
          person.alder should be > 0
        }
      }

      it("implementer person slik at to med likt navn og alder er identiske(equals)") {
        val person1: AnyRef = Person("Torbjørn", 32)
        val person2: AnyRef = Person("Torbjørn", 32)

        person1 should equal(person2)
      }

      it("implement person slik at hash code er ihenhold til java standard") {
        val person1: AnyRef = Person("Torbjørn", 32)
        val person2: AnyRef = Person("Torbjørn", 32)

        person1.hashCode should equal(person2.hashCode)
      }

      it("kopier en person inn i en annen variabel (egentlig ikke en case class greie)") {
        val person = Person("Aslak", 12)
        val person1: navnOgAlder = person
        val person2: navnOgAlder = person.copy(alder = 12)

        person1 should not be theSameInstanceAs(person2)

        skal_ha_samme_navn_og_alder(person1, person2)


        type navnOgAlder = {val navn: String; val alder: Int}

        def skal_ha_samme_navn_og_alder(a: navnOgAlder, b: navnOgAlder) = {
          a.navn should equal(b.navn)
          a.alder should equal(b.alder)
        }
      }
    }

    describe("oppgave 5 - pattern matching") {
      it("Finn alle blomster over 20 cm") {
        val hoyeBlomster = EksempelData.blomster.filter(blomst => {
          blomst match {
            case Blomst(_, hoyde, _) if hoyde > 20 => true
            case _ => false
          }
        })
        hoyeBlomster.foreach(_.hoyde should be > (20))
      }

      it("Finn alle pene blomster(som har Pen som superklasse)") {
        val peneBlomster: List[Blomst] = EksempelData.blomster.filter( _ match {
          case _:Pen => true
          case _ => false
        })

        peneBlomster.size should be(2)
        peneBlomster should not contain (Blomst("Løvetann", 8, Utseende(Farge("Gul"))))
      }

      it("Hent fargen på blomsten") {
        val farger: List[String] = EksempelData.blomster.map( _ match {
          case Blomst(_, _, Utseende(Farge(farge))) => farge
        })

        farger should be(List("Rød", "Blå", "Gul"))
      }

    }

    describe("oppgave 6 - traits") {

      it("Finn den største bukkene bruse") {
        val bukkene = EksempelData.bukkeneBruse

        val størsteBukken: Bukk = bukkene.max
        //Hint: bruk max() på lista og legg til Ordered-traitet på Bukk-klassen

        størsteBukken.navn should be ("Største")
      }

      it("Få bukken til å trampe på brua") {

        val enBukk = new Bukk("Aslak", "L") with Tramping {
          def trampe = "Tramp tramp!"
        }

        enBukk.trampe should be ("Tramp tramp!")
      }

      it("Få bukken til å stange trollet") {

        val enBukk = new Bukk("Store", "L") with Stanging {
          override def stange = "Trollet"
        }

        enBukk.stange should be ("Trollet")
      }

      it("Lag en geitekilling som sier 'meee'") {

        // Hint: her må man lage en egen BukkSomKilling-klasse og bruke "stackable"-traitet Killing
        val killing = new Bukk("bitteLille", "XS"){
          override def siMæ = "meeee"
        }

        killing.siMæ should be ("meeee")

      }

    }

  }
}
