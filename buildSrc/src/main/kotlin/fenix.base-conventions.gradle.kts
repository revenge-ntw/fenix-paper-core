import com.diffplug.gradle.spotless.FormatExtension

plugins {
  `java-library`
  id("net.kyori.indra")
  id("net.kyori.indra.checkstyle")
  id("com.diffplug.spotless")
}

indra {
  javaVersions {
    target(17)
    minimumToolchain(17)
  }

  checkstyle("10.8.0")
}

dependencies {
  checkstyle("ca.stellardrift:stylecheck:0.2.0")
}

spotless {
  fun FormatExtension.applyCommon() {
    trimTrailingWhitespace()
    indentWithSpaces(2)
    endWithNewline()
  }
  java {
    importOrder("", "\\#")
    removeUnusedImports()
    applyCommon()
  }
  kotlinGradle {
    applyCommon()
  }
}

repositories {
  mavenLocal()
  maven("https://repo.revengenetwork.es/repository/libs/") {
    name = "revengeRepository"
    credentials(PasswordCredentials::class)
  }
}

tasks {
  compileJava {
    dependsOn("spotlessApply")
    dependsOn("checkstyleMain")
    options.compilerArgs.add("-parameters")
  }
}