plugins {
    id("com.google.devtools.ksp") version "1.6.21-1.0.6"
    kotlin("plugin.jpa") version "1.6.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))

    ksp("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.querydsl:querydsl-core:5.0.0")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    ksp("com.querydsl:querydsl-apt:5.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}