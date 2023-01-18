plugins {
    kotlin("plugin.jpa") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    implementation("io.hypersistence:hypersistence-utils-hibernate-60:3.1.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}