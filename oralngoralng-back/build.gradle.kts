import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.asciidoctor.convert") version "1.5.8"
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21"
    kotlin("plugin.jpa") version "1.7.21"
    kotlin("kapt") version "1.7.21"
//    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

allprojects {
    apply {
        plugin("kotlin")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
//        plugin("org.jlleitschuh.gradle.ktlint")
    }

    group = "com.t4er"
    version = "1.0.0"
    java.sourceCompatibility = JavaVersion.VERSION_17

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    repositories {
        mavenCentral()
    }

    val snippetsDir by extra { file("build/generated-snippets") }

    allOpen {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("org.springframework.boot:spring-boot-starter-graphql")
        implementation("org.springframework.boot:spring-boot-starter-validation")

        implementation("org.flywaydb:flyway-core")
        implementation("org.flywaydb:flyway-mysql")
        runtimeOnly("com.h2database:h2")
        runtimeOnly("mysql:mysql-connector-java")

        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
        implementation("org.springframework.kafka:spring-kafka")

        implementation("org.springframework.boot:spring-boot-starter-actuator")
        runtimeOnly("io.micrometer:micrometer-registry-prometheus")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework:spring-webflux")
        testImplementation("org.springframework.graphql:spring-graphql-test")
        testImplementation("org.springframework.kafka:spring-kafka-test")

        implementation("io.kotest:kotest-property-jvm:5.5.4")
        testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
        testImplementation("io.kotest:kotest-assertions-core-jvm:5.5.4")
        implementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")

        testImplementation("io.mockk:mockk:1.13.2")

        implementation("io.jsonwebtoken:jjwt-api:0.11.5")
        runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
        runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    }

//     ktlint setting 3
    /*    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
            verbose.set(true)
            disabledRules.set(
                setOf(
                    "import-ordering",
                    "no-wildcard-imports",
                    "final-newline",
                    "insert_final_newline",
                    "max_line_length"
                )
            )
        }*/

    tasks.withType<KotlinCompile> {
//        dependsOn("ktlintCheck")
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.test {
        outputs.dir(snippetsDir)
    }
}
