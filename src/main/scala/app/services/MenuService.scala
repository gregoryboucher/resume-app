package services

import dispatch._, Defaults._
import scala.concurrent.future


// TODO: Need to log service calls
// TODO: Need to figure out how to validate this is working, not just compiling...

class MenuService(MenuName: String) {

  def getMenuJson(MenuName: String) = {
	val svc = url("http://me.mapquest.com:8080/menu/"+MenuName+".json")
	Http(svc OK as.String)
  }
}

object MenuService extends services.MenuService("header")

//TODO: Why is the object required for me to be able to import MenuService and call getMenuJson
//TODO: How do I get the value I need passed in?
//TODO: Should move on from this, since you have no real need and no backend...