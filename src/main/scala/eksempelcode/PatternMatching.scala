package eksempelcode

case class Farge(val navn:String)

case class Bil(val farge:Farge, val hjul:Int)

object PatternMatcingApp extends Application{
  def godkjenntBil(dings: AnyRef)={
    dings match {
      case Bil(_, hjul) if hjul <= 2 => println("En slik bil heter gjerne motorsykkel")
      case Bil(_, 4) => println("helt vanelig bil")
      case Bil(Farge(fargePaBil), _) if fargePaBil.equals("rød") => println("Jippi en rød bil!")
      case s@Bil(farve, _) if farve != null => println("dette er en " + farve.navn + " bil")
      case s:Bil => println("dette er en bil")
      case _ => println("dette kan være hva som helst uten om en bil")
    }
  }
}