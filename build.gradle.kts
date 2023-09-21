plugins {
    id("java")
    id("io.qameta.allure") version("2.11.2")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("junit:junit:4.13.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.microsoft.playwright:playwright:1.28.1")

    testImplementation("com.codeborne:selenide:6.11.0")
    testImplementation("com.codeborne:selenide-proxy:6.11.0")
}

tasks.test {
    useJUnitPlatform()
}