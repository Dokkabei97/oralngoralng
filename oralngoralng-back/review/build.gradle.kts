plugins {
    kotlin("kapt") version "1.7.21"
    kotlin("plugin.jpa") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    val kapt by configurations

    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")

    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("com.querydsl:querydsl-core:5.0.0")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0")

    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}