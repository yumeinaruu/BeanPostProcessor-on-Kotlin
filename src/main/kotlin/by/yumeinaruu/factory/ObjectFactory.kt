package by.yumeinaruu.factory

import by.yumeinaruu.annotation.InjectProperty
import by.yumeinaruu.config.BeanPostProcessor
import by.yumeinaruu.config.Config
import by.yumeinaruu.config.KotlinConfig
import by.yumeinaruu.git.GitHelper
import by.yumeinaruu.git.GitHelperPull
import java.io.File

class ObjectFactory private constructor(
    private val config: Config,
    private val configurators: MutableList<BeanPostProcessor>,
) {

    constructor() : this(
        config = KotlinConfig(
            "by.yumeinaruu",
            cache = mutableMapOf(GitHelper::class.java to GitHelperPull::class.java)
        ),
        configurators = buildConfigurators()
    )

    fun <T> createBean(type: Class<T>): T {
        var implClass: Class<out T> = type
        if (type.isInterface) {
            implClass = config.getImplementation(type)
        }

        val t: T = implClass.getDeclaredConstructor().newInstance()

        configurators.forEach { configurator -> configurator.configure(t as Any) }

        return t
    }

    companion object {
        private val ourInstance = ObjectFactory()

        fun getInstance(): ObjectFactory {
            return ourInstance
        }

        private fun buildConfigurators(): MutableList<BeanPostProcessor> {
            val scanner = KotlinConfig("by.yumeinaruu").getScannerFromOutside()
            val configurators: MutableList<BeanPostProcessor> = mutableListOf()
            for (aClass in scanner.getSubTypesOf(BeanPostProcessor::class.java)) {
                configurators.add(aClass.getDeclaredConstructor().newInstance())
            }
            return configurators
        }
    }
}