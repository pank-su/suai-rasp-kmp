plugins{
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin{
    jvm()

    sourceSets {
        commonMain{
            dependencies {
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.kotlinx.datetime)
                implementation(projects.suaiSchedule)
                implementation("com.github.ajalt.clikt:clikt:4.4.0")
                implementation(libs.ktor.client.java)
                //implementation(projects.suai.schedule)
            }
        }
        

    }
}