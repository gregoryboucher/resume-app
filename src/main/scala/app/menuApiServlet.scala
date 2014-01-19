package app

import org.scalatra._
import scalate.ScalateSupport
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import controllers.MenuData

class menuApiServletJson extends ResumeAppStack with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/:menuName.json") {
    val menuName:String = params.getOrElse("menuName", "header").toLowerCase
    MenuData.getMenu(menuName)
  }
}
