
import sbt._

class ScalaIntroKurs(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val scalatest = "org.scalatest" % "scalatest" % "1.3"
}