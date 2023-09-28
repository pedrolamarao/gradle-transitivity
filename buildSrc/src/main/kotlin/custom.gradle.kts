import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering

enum class CustomVisibility {
    COMPILE,
    RUN;
}

val CUSTOM_VISIBILITY_ATTRIBUTE = Attribute.of("custom.visibility",CustomVisibility::class.java)

val customApi by configurations.registering {
    description = "custom api dependencies"
    isCanBeConsumed = false
    isCanBeResolved = false
}

val customApiElements by configurations.registering {
    description = "custom api elements"
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes {
        attribute(CUSTOM_VISIBILITY_ATTRIBUTE,CustomVisibility.COMPILE)
    }
}

val customImplementation by configurations.registering {
    description = "custom implementation dependencies"
    extendsFrom(customApi.get())
    isCanBeConsumed = false
    isCanBeResolved = false
}

val customImplementationElements by configurations.registering {
    description = "custom implementation elements"
    extendsFrom(customImplementation.get())
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes {
        attribute(CUSTOM_VISIBILITY_ATTRIBUTE,CustomVisibility.RUN)
    }
}

val customCompileDependencies by configurations.registering {
    description = "custom compile dependencies"
    extendsFrom(customImplementation.get())
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes {
        attribute(CUSTOM_VISIBILITY_ATTRIBUTE,CustomVisibility.COMPILE)
    }
}

val customRunDependencies by configurations.registering {
    description = "custom runtime dependencies"
    extendsFrom(customApi.get(),customImplementation.get())
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes {
        attribute(CUSTOM_VISIBILITY_ATTRIBUTE,CustomVisibility.RUN)
    }
}