plugins {
  id("fenix.publishing-conventions")
}

dependencies {
  api(project(":fenix-inject"))

  compileOnly(libs.paper.base)
}
