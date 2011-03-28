package model

abstract class Kjøretøy(val antallHjul:Int){
  def motor:String;
}


class Bil extends  Kjøretøy(4){
  def motor = "Bensin"
}