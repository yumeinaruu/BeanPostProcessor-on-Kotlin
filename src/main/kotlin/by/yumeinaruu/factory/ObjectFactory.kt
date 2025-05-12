package by.yumeinaruu.factory

import by.yumeinaruu.config.Config
import by.yumeinaruu.config.KotlinConfig
import by.yumeinaruu.git.GitHelper
import by.yumeinaruu.git.GitHelperPull

class ObjectFactory private constructor() {

    private val config: Config = KotlinConfig(
        "by.yumeinaruu",
        cache = mutableMapOf(GitHelper::class.java to GitHelperPull::class.java)
    )

    fun <T> createBean(type: Class<T>): T {
        var implClass: Class<out T> = type
        if (type.isInterface) {
            implClass = config.getImplementation(type)
        }

        val t: T = implClass.getDeclaredConstructor().newInstance()

        return t
    }

    companion object {
        private val ourInstance = ObjectFactory()

        fun getInstance(): ObjectFactory {
            return ourInstance
        }
    }
}