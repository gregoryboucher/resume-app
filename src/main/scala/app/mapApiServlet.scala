package app

import org.scalatra._
import scalate.ScalateSupport
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class mapApiServletJson extends ResumeAppStack with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/map.json?:queryString") {
    val queryString:String = params.getOrElse("queryString", "test").toLowerCase
    //MenuData.getMenu(menuName)
  }
}


//TODO:  This is to act as a middleware for map APIs - should act as an abstraction to existing APIs