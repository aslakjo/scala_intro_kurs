package controllers

import play.mvc._
object ScoreKeeper {
  var scoreMap = Map[String, (Int, Int, Int)]()
}

object ScoreBoard extends Controller {

  def index = {
    ScoreKeeper.scoreMap match {
      case m: Map[String, (Int, Int, Int)] => {
        val scoreBoard = createScoreBoard(m); Template(scoreBoard)
      }
      case _ => throw new ClassCastException
    }
  }

  private def createScoreBoard(map: Map[String, (Int, Int, Int)]) = {
    map.foldLeft(List[String]()) {
      case (l, (key, value)) => "[<span id='team'>" + key + "</span>] Passed: <span id='passed'>" + value._1 + "</span> Failed: <span id='failed'>" + value._2 + "</span> " +
        "Skipped: <span id='skipped'>" + value._3+"</span>" :: l
    }
  }
}

object PublishScore extends Controller {

  def index(name: String, passed: Int, failed: Int, skipped: Int) = {
    ScoreKeeper.scoreMap += (name -> (passed, failed, skipped))
  }
}