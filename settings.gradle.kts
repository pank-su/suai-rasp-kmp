enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "rasp-api"

include(":suai-schedule")
include("example:cli")