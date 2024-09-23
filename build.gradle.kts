plugins {
    kotlin("jvm") version "2.0.0"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "org.hanazono"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}