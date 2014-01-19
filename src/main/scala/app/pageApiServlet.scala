package app

import org.scalatra._
import scalate.ScalateSupport
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import controllers.MenuData

class pageApiServletJson extends ResumeAppStack with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/:pageSlug.json") {
    val menuName:String = params.getOrElse("pageSlug", "home").toLowerCase
    //MenuData.getMenu(pageSlug)
  }
}
