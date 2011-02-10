
/**
 * Created by IntelliJ IDEA.
 * User: aslak johannessen
 * Date: 2/10/11
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */

import sbt._
class ScalaIntroKurs(info: ProjectInfo) extends DefaultProject(info)
{
  val sbtIdeaRepo = "sbtIdeaRepo" at "http://mpeltonen.github.com/maven/"
  def idea = "com.github.mpeltonen" % "sbt-idea-processor" %  "0.1.0"
}