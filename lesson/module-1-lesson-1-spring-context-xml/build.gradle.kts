plugins {
    id("java")
}

dependencies {
    implementation("org.springframework:spring-context:6.1.3")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}