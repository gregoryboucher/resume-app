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
			Menu(0, "About", "#aboutFooter"),
			Menu(1, "Contact", "#contactFooter"),
			Menu(2, "More", "#moreFooter"))
		case "sidebar" => List(
			Menu(0, "About", "#aboutSidebar"),
			Menu(1, "Contact", "#contactSidebar"),
			Menu(2, "More", "#moreSidebar"))
		case "header" | _ => List(
			Menu(0 ,"About", "#about"),
			Menu(1, "Contact", "#contact"),
			Menu(2, "More", "#more"))
	}
}