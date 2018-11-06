import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.71"
}

dependencies {
    compile(kotlin("stdlib"))
    implementation("io.github.microutils:kotlin-logging:1.6.10")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

repositories {
    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
