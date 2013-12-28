package controllers

import models.Menu

class MenuController {

}

object MenuData {

  /**
   * Some fake menu data so we can simulate retrievals.
   */
	def getMenu(name: String): List[Menu] = name match {
		case "footer" => List(
			Menu("About", "#aboutFooter"),
			Menu("Contact", "#contactFooter"),
			Menu("More", "#moreFooter"))
		case "sidebar" => List(
			Menu("About", "#aboutSidebar"),
			Menu("Contact", "#contactSidebar"),
			Menu("More", "#moreSidebar"))
		case "header" | _ => List(
			Menu("About", "#about"),
			Menu("Contact", "#contact"),
			Menu("More", "#more"))
	}
}