

object EksempelData{
  val liste1 = List(1,2,3)
  val liste2 = List(4,5,6)
  val tallFraEnTilFem = Range(1,6).toList

  val blomster = List(
    new Blomst("Rose", 10, Utseende(Farge("Rød"))) with Pen,
    new Blomst ("Blåveis", 5, Utseende(Farge("Blå"))) with Pen,
    Blomst("Løvetan", 8, Utseende(Farge("Gul")))
  )
}

trait Pen
case class Utseende(val farge:Farge)
case class Farge(val navn:String)


case class Blomst(val navn:String, val hoyde:Int, val utseende:Utseende)