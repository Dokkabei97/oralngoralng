plugins {
    kotlin("plugin.jpa") version "1.7.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    // spring data elasticsearch 는 버전에 따라 지원 하는 elasticsearch 버전이 다르니 버전을 고정
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    implementation("io.hypersistence:hypersistence-utils-hibernate-60:3.1.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}