
/**
 * Created by IntelliJ IDEA.
 * User: aslak johannessen
 * Date: 2/10/11
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */

import sbt._
class ScalaIntroKurs(info: ProjectInfo) extends DefaultProject(info) with IdeaProject
{
  val scalatest = "org.scalatest" % "scalatest" % "1.2"
}