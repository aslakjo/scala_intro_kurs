package eksempeldata

object EksempelData{

  val liste1 = List(1,2,3)
  val liste2 = List(4,5,6)
  val tallFraEnTilFem = Range(1,6).toList

  // "Case class"-oppgavene
  val blomster = List(
    new Blomst("Rose", 10, Utseende(Farge("Rød"))) with Pen,
    new Blomst ("Blåveis", 5, Utseende(Farge("Blå"))) with Pen,
    Blomst("Løvetan", 8, Utseende(Farge("Gul")))
  )

  // Traits-oppgavene
  val bukkeneBruse = List(
    new Bukk("Lille", størrelse = "S"),
    new Bukk("Mellom", størrelse = "M"),
    new Bukk("Største", størrelse = "L")
  )

}

// "Case class"-oppgavene
trait Pen
case class Utseende(val farge:Farge)
case class Farge(val navn:String)
case class Blomst(val navn:String, val hoyde:Int, val utseende:Utseende)

// Traits-oppgavene
case class Bukk(navn: String, størrelse: String) extends Ordered[Bukk] {
  override  def compare(other:Bukk) = other.størrelse compareTo størrelse
  def siMæ = "MÆÆÆÆ"
}

trait Tramping {
  def trampe: String
}

trait Stanging {
  def stange = "Heksa"
}

trait Killing extends Bukk {
  override def siMæ = "meeee"
}