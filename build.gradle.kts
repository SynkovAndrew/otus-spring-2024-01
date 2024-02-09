plugins {
    id("java")
}

group = "com.otus.spring"
version = "1.0"

subprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }
}