package controllers

import play.mvc._
import reflect.Template

object ScoreKeeper {
  var scoreMap = Map[String, (Int, Int, Int)]()
}

object ScoreBoard extends Controller {

    def index = {
       ScoreKeeper.scoreMap match {
         case m: Map[String, (Int, Int, Int)] => {val scoreBoard = createScoreBoard(m); Template(scoreBoard)}
         case _ => throw new ClassCastException
       }
    }

    private def createScoreBoard(map: Map[String, (Int, Int, Int)]) = {
      map.foldLeft(List[String]()) {
        case (l,(key,value)) => "Team: "+key+" Passed: "+value._1+" Failed: "+value._2+" Skipped: "+value._3 :: l
      }
    }
}

object PublishScore extends Controller {

  def index(name: String, passed: Int, failed: Int, skipped: Int) = {
    ScoreKeeper.scoreMap += (name -> (passed, failed, skipped))
  }
}