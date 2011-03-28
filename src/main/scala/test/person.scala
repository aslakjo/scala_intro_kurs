package test

class Person(
   navn:String,
   etternavn:String,
   alder:Int)
{
  val interesser = List("ting", "og", "tang")
  val cv = "%s %s -- %s\n Liker: %s".format(navn, etternavn, alder, interesser.mkString(";"))
  def fulltNavn ={
    "%s %s".format(navn, etternavn)
  }

  def mineInteresser ={
    var interesser = ""
    for(interesse <- interesser){
    	interesser += interesse + ", "
    }

    interesser
  }
}