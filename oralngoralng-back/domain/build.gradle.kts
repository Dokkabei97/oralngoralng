import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("kapt") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.t4er"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
//    implementation("org.apache.kafka:kafka-streams")
//    implementation("org.springframework.kafka:spring-kafka")

    kapt("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")

//    testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<BootJar> {
    enabled = false
}