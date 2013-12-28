import app._
import models._
import controllers._
//import helpers._
import services._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
        try {
      context mount (new menuAppServletJson, "/menu")
      context mount (new resumeAppServlet, "/")
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }
}