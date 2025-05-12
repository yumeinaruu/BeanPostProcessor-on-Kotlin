package by.yumeinaruu.config

import by.yumeinaruu.annotation.InjectProperty
import java.io.File

class InjectPropertyAnnotationBeanPostProcessor(
    private val path: String? = ClassLoader.getSystemClassLoader().getResource("app.properties")!!.path,
    private val propertiesMap: Map<String, String> = File(path!!).bufferedReader().use { reader ->
        reader.lineSequence()
            .map { line ->
                line.split("=", limit = 2).let {
                    it[0] to it.getOrElse(1) { "" }
                }
            }
            .toMap()
    }
) : BeanPostProcessor {
    override fun configure(t: Any) {
        val implClass: Class<*> = t.javaClass
        for (field in implClass.declaredFields) {
            val annotation: InjectProperty = field.getAnnotation(InjectProperty::class.java) ?: continue
            val value: String = if (annotation.value.isEmpty()) {
                propertiesMap[field.name] ?: "undefined"
            } else {
                propertiesMap[annotation.value] ?: "undefined"
            }
            field.isAccessible = true
            field.set(t, value)
        }
    }
}