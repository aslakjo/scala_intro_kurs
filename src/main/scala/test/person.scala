package test

class Person(
              navn: String,
              etternavn: String,
              alder: Int) {
  val interesser = List("ting", "og", "tang")
  val cv = "%s %s -- %s\n Liker: %s".format(navn, etternavn, alder, interesser.mkString(";"))

  def fulltNavn = {
    "%s %s".format(navn, etternavn)
  }

  def mineInteresser = {
    var interesser = ""
    for (interesse <- interesser) {
      interesser += interesse + ", "
    }

    interesser
  }
}


class App {
  //Scala liste opperator ::
  val etTog = new Vogn :: new Vogn :: new Vogn :: Nil

  class Vogn {
    def +(vogn: Vogn) = List(this, vogn)

    def ::(vogn: Vogn) = List(this, vogn)
  }

  // Vår egen syntaks
  val tog = new Vogn + new Vogn
  val tog2 = new Vogn :: new Vogn :: new Vogn
  println(tog2)


  val liste = List("en", "to", "tre")

  def prat2Rop(tekst: String) = "%s!".format(tekst)
  liste.map(prat2Rop(_))

  var ropeList = List[String]()
  for(i <- liste){
    ropeList = "%s!".format(i) :: ropeList
  }


object Logger{
  def error(msg:String) = println ("ÆÆÆ! : " + msg)
}

trait Loggable{
  def error(msg: String) = Logger.error(msg)
}

class ServiceA extends Loggable{  }
class ServiceB extends Loggable{  }



  val list = List(1,2,3)
  list(0) == 1 //samme som list.apply(0)

  val to = 1 + 1 // sammen som 1.+(1)

}