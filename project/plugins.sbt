addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.4.2")

addSbtPlugin("org.scalatra.sbt" % "scalatra-sbt" % "0.3.2")

//Used for dev versions only 
//resolvers += Resolver.url("untyped", url("http://ivy.untyped.com"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.untyped" % "sbt-less"	% "0.6")

addSbtPlugin("com.untyped" % "sbt-js" % "0.6")
