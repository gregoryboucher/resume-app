logLevel := Level.Debug

seq(lessSettings:_*)

(excludeFilter in (Compile, LessKeys.less)) := ((".*" - ".") || "_*" || "_*.less" || HiddenFileFilter)

(sourceDirectory in (Compile, LessKeys.less)) <<= (sourceDirectory in Compile)(_ / "scala" / "app" / "less" )

(resourceManaged in (Compile, LessKeys.less)) <<= (sourceDirectory in Compile) { _ / "webapp" / "css" / "compiled" }

(compile in Compile) <<= compile in Compile dependsOn (LessKeys.less in Compile)

seq(jsSettings : _*)

(includeFilter in (Compile, JsKeys.js)) := ("*.jsm": FileFilter)

(sourceDirectory in (Compile, JsKeys.js)) <<= (sourceDirectory in Compile)(_ / "scala" / "app" / "javascript" )

(resourceManaged in (Compile, JsKeys.js)) <<= (sourceDirectory in Compile) { _ / "webapp" / "js" / "compiled" }

(compile in Compile) <<= compile in Compile dependsOn (JsKeys.js in Compile)