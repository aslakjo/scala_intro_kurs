package controllers

import play.jobs._
import akka.actor.Actor._
import akka.actor.ActorRegistry
import akka.actor.Actor

@OnApplicationStart
class Bootstrap extends Job {

  override def doJob(): Unit = {

    Actor.remote.start("localhost", 9999)
    Actor.remote.register("scoreKeeper", actorOf[ScoreKeeperActor].start)

  }
}

case object GetScore {}
case class ReportScore(team: Int, right: Int, wrong: Int) {}

class ScoreKeeperActor extends Actor {

  var map = Map[Int, (Int, Int)]()

  def receive = {
    case GetScore => self.reply(map)
    case event: ReportScore => map += (event.team -> (event.right, event.wrong))
  }

}