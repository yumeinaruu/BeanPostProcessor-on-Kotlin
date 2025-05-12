package by.yumeinaruu.config

interface Config {

    fun <T> getImplementation(type: Class<T>): Class<out T>

}