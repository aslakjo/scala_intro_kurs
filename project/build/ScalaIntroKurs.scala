import com.withoutincident.sbt.GrowlTestListenerPlugin
import sbt._

class ScalaIntroKurs(info: ProjectInfo) extends DefaultProject(info) with IdeaProject with GrowlTestListenerPlugin with ScoreBoardPublish {
  val scalatest = "org.scalatest" % "scalatest" % "1.3"

  def customTestListener: TestReportListener = new ScoreBoardUpdater(this)
  override def testListeners: Seq[TestReportListener] = super.testListeners ++ Seq(customTestListener)

  def publishScore(passed: Int, failed: Int, skipped: Int) = {
    println("Passed: "+passed+" Failed: "+failed+" Skipped: "+skipped)
  }
}