plugins {
    id("custom")
    id("java-library")
}

dependencies {
    api(project(":base"))
    customApi(project(":base"))
    implementation(project(":internal"))
    customImplementation(project(":internal"))
}