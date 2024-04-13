plugins {
  id("fenix.publishing-conventions")
}

dependencies {
  api("com.google.inject:guice:5.1.0")
  compileOnlyApi(libs.annotations)
}
