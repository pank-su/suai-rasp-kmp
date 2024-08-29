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
            }
        }
        commonTest{
            dependencies{
                implementation(libs.ktor.client.mock)
            }
        }
    }
}