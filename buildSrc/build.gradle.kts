plugins {
  `kotlin-dsl`
}

dependencies {
  implementation("net.kyori:indra-common:3.0.1")
  implementation("com.diffplug.spotless:spotless-plugin-gradle:6.18.0")
}

repositories {
  gradlePluginPortal()
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "17"
    }
  }
}