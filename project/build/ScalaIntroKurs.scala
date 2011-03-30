import com.withoutincident.sbt.GrowlTestListenerPlugin
import io.Source
import sbt._

class ScalaIntroKurs(info: ProjectInfo) extends DefaultProject(info) with IdeaProject with GrowlTestListenerPlugin with ScoreBoardPublish {
  val scalatest = "org.scalatest" % "scalatest" % "1.3"

  val host = "localhost"
  val teamNavn = "A-Team"

  def customTestListener: TestReportListener = new ScoreBoardUpdater(this)
  override def testListeners: Seq[TestReportListener] = super.testListeners ++ Seq(customTestListener)

  def publishScore(passed: Int, failed: Int, skipped: Int) = {
    Source.fromURL ("http://%s:9000/team/%s/passed/%s/failed/%s/skipped/%s" format (host, teamNavn, passed, failed, skipped))
  }
}