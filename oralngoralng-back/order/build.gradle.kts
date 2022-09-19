plugins {
    kotlin("kapt") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

repositories {
    mavenCentral()
}

dependencies {
    val kapt by configurations

    implementation(project(":common"))

    kapt("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.querydsl:querydsl-core:5.0.0")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}