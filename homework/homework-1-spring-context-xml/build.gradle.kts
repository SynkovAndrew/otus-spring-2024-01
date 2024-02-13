plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.freefair.lombok") version "8.4"
}

dependencies {
    implementation("org.springframework:spring-context:6.1.3")
    implementation("com.opencsv:opencsv:5.9")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "com.otus.spring.Main"
    }
}

tasks.test {
    useJUnitPlatform()
}