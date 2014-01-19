package app

import org.scalatra._
import scalate.ScalateSupport

class resumeAppServlet extends ResumeAppStack {

  get("/") {
    contentType = "text/html"
    scaml("resume-layout")
  }
  
  get("/simple") {
	contentType = "text/html"
	scaml("hello-scalate")
  }

  get("/more") {
    contentType = "text/html"
    scaml("nested-layout")
  }

  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}
