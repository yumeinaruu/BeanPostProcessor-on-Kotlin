package by.yumeinaruu.config

import org.reflections.Reflections

interface Config {

    fun <T> getImplementation(type: Class<T>): Class<out T>

    fun getScannerFromOutside(): Reflections
}