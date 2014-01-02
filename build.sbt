logLevel := Level.Debug

seq(lessSettings:_*)

(excludeFilter in (Compile, LessKeys.less)) := ("*twitter*": FileFilter)

(sourceDirectory in (Compile, LessKeys.less)) <<= (sourceDirectory in Compile)(_ / "webapp" / "less" )

(resourceManaged in (Compile, LessKeys.less)) <<= (sourceDirectory in Compile) { _ / "webapp" / "css" / "compiled" }

seq(jsSettings : _*)

(includeFilter in (Compile, JsKeys.js)) := ("*.jsm": FileFilter)

(excludeFilter in (Compile, LessKeys.less)) := ("*twitter*": FileFilter)

(sourceDirectory in (Compile, JsKeys.js)) <<= (sourceDirectory in Compile)(_ / "webapp" / "javascript" )

(resourceManaged in (Compile, JsKeys.js)) <<= (sourceDirectory in Compile) { _ / "webapp" / "js" / "compiled" }
