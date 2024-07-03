plugins {
    id("java")
}

group = "eu.wejsonekk.bombocraft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    gradleKotlinDsl()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}