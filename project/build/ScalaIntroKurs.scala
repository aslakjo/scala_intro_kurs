import com.withoutincident.sbt.GrowlTestListenerPlugin
import sbt._

class ScalaIntroKurs(info: ProjectInfo) extends DefaultProject(info) with IdeaProject with GrowlTestListenerPlugin {
  val scalatest = "org.scalatest" % "scalatest" % "1.3"
}