import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("kapt") version "1.6.21"
}

group = "com.t4er"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":interface"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<BootJar> {
    enabled = false
}