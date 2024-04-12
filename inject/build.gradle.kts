plugins {
  id("fenix.publishing-conventions")
}

dependencies {
  api("com.google.inject:guice:7.0.0")
  compileOnlyApi(libs.annotations)
}
