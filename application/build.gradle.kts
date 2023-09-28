plugins {
    id("custom")
    id("java-library")
}

dependencies {
    implementation(project(":intermediate"))
    customImplementation(project(":intermediate"))
}
