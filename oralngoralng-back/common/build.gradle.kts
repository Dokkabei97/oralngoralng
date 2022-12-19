import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("kapt") version "1.7.21"
    kotlin("plugin.jpa") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    val kapt by configurations
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.apache.commons:commons-lang3:3.12.0")

    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("com.querydsl:querydsl-core:5.0.0")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0")

    testImplementation("org.springframework.security:spring-security-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<BootJar> {
    enabled = false
}