plugins {
    kotlin("jvm") version "2.1.10"
}

group = "by.dzengo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // https://mvnrepository.com/artifact/org.reflections/reflections
    implementation("org.reflections:reflections:0.9.12")

    // https://mvnrepository.com/artifact/javax.annotation/jsr250-api
    implementation("javax.annotation:jsr250-api:1.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}