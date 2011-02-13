package eksempelcode


trait HealthCheckable{
  def isOk: Boolean
}

trait Logger {
  def log(message: String):Unit = println(message)
}

trait LoggProcessing extends FooService{
  def log(message:String):Unit

  override def process:Unit={
    log("Starting processing")
    super.process
    log("Stopped processing")
  }
}

class FooService extends HealthCheckable with Logger{
  def isOk:Boolean = true

  def process = {
    //go allot!
  }
}

object Application{
  new FooService with LoggProcessing
}