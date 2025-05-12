package by.yumeinaruu

import by.yumeinaruu.factory.ObjectFactory
import java.util.concurrent.ConcurrentHashMap

class ApplicationContext(
    private val factory: ObjectFactory,
    private val cache: MutableMap<Class<Any>, Any> = ConcurrentHashMap(),
) {

    fun <T> getBean(type: Class<T>): T {
        TODO()
    }

}