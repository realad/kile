import org.gradle.api.Project

fun log(message: String) {
    println("LOG: $message")
}

fun warn(message: String) {
    println("WARNING: $message")
}

fun Project.getPropertyOrEnv(
    propertyKey: String,
    envVariable: String? = null,
    default: String = "no value"
): String {
    val valueFromProperty = property(propertyKey)?.toString()
    return if (valueFromProperty.isNullOrBlank()) {
        warn("$propertyKey is not set")
        val valueFromEnv = System.getenv(envVariable)
        if (valueFromEnv.isNullOrBlank()) {
            warn("$envVariable is not set")
            default
        } else {
            log("$envVariable is found")
            valueFromEnv
        }
    } else {
        log("$propertyKey is found")
        valueFromProperty
    }
}
