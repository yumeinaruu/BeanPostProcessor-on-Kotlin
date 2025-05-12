package by.yumeinaruu.config

import org.reflections.Reflections

class KotlinConfig(
    private val packagesToScan: String,
    private val scanner: Reflections = Reflections(packagesToScan),
    private val cache: MutableMap<Class<*>, Class<*>> = mutableMapOf(),
) : Config {

    @Suppress("UNCHECKED_CAST")
    override fun <T> getImplementation(type: Class<T>): Class<out T> {
        return cache.computeIfAbsent(type) { key ->
            val classes = scanner.getSubTypesOf(key as Class<T>)
                .takeIf { it.isNotEmpty() }
                ?: throw RuntimeException("No implementations found for $key")

            if (classes.size > 1) {
                throw RuntimeException("Multiple implementations found for $key: $classes")
            }

            classes.first()
        } as Class<out T>
    }
}