import sbt._
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {

  val sbtIdeaRepo = "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
  val sbtIdea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.2.0"

  val scoreboard = "no.bekk" % "scoreboardupdater" % "1.0" from "http://cloud.github.com/downloads/torbjornvatn/ScoreBoardUpdater/scoreboardupdater-1.0.jar"
  //val scoreboard = "no.bekk" % "scoreboardupdater" % "1.0"

}
