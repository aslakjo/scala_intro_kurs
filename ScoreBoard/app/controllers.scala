package controllers

import play._
import play.mvc._
import templates.Template
import akka.actor.ActorRegistry
import akka.actor.Actor
import reflect.Template

object ScoreKeeper {
  val actor = Actor.remote.actorFor("scoreKeeper", "localhost", 9999)
}

object ScoreBoard extends Controller {

    def index = {
      val scoreMap = (ScoreKeeper.actor !! GetScore).getOrElse(Map.empty)
       scoreMap match {
         case m: Map[Int, (Int,Int)] => {val scoreBoard = createScoreBoard(m); Template(scoreBoard)}
         case _ => throw new ClassCastException
       }
    }

    private def createScoreBoard(map: Map[Int, (Int, Int)]) = {
      map.foldLeft(List[String]()) {
        case (l,(key,value)) => "Team: "+key+" Riktige: "+value._1+" Feil:"+value._2 :: l
      }
    }
}

object TestClient extends Controller {

  def index = {
    ScoreKeeper.actor ! ReportScore(3, 9, 8)
  }

}