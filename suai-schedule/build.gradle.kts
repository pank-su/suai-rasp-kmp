plugins{
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin{
    jvm()
    linuxX64()
    mingwX64()

    sourceSets {
        commonMain{
            dependencies {
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.serialization.json)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.kotlinx.datetime)
            }
        }
        commonTest{
            dependencies{
                implementation(libs.ktor.client.mock)
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0-RC.2")
            }
        }
    }
}