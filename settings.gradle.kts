pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Movie App"
include(":app")
include(":feature:movie:data")
include(":feature:movie:domain")
include(":feature:movie:ui")
include(":feature:movie_details:data")
