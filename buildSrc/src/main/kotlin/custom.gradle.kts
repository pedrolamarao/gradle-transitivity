import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering

val customApi by configurations.registering {
    description = "custom api dependencies"
    isCanBeConsumed = false
    isCanBeResolved = false
}

val customImplementation by configurations.registering {
    description = "custom implementation dependencies"
    extendsFrom(customApi.get())
    isCanBeConsumed = false
    isCanBeResolved = false
    isVisible = false
}

val customCompile by configurations.registering {
    description = "custom compile dependencies"
    extendsFrom(customImplementation.get())
    isCanBeConsumed = false
    isCanBeResolved = true
    isVisible = false
}

val customRuntime by configurations.registering {
    description = "custom runtime dependencies"
    extendsFrom(customApi.get(),customImplementation.get())
    isCanBeConsumed = false
    isCanBeResolved = true
    isVisible = false
}
