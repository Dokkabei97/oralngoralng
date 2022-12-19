plugins {
    kotlin("plugin.jpa") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}