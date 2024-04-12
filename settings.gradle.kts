rootProject.name = "fenix"

includePrefixed("inject")

listOf("core").forEach {
  includePrefixed("paper:$it")
}

fun includePrefixed(name: String) {
  val kebabName = name.replace(":", "-")
  val path = name.replace(":", "/")
  val baseName = "${rootProject.name}-$kebabName"

  include(baseName)
  project(":$baseName").projectDir = file(path)
}