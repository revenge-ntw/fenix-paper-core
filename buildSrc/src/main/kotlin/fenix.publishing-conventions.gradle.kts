plugins {
  id("fenix.base-conventions")
  `maven-publish`
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["java"])
    }
  }
  /*repositories {
    maven {
      name = "revengeRepository"
      val repositoryUrl = "https://repo.revengenetwork.es/repository/libs-${
        if (version.toString().endsWith("SNAPSHOT")) "snapshots" else "releases"
      }/"
      url = uri(repositoryUrl)
      credentials(PasswordCredentials::class)
    }
  }*/
}