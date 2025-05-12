package by.yumeinaruu.recommendator

import by.yumeinaruu.annotation.InjectProperty
import by.yumeinaruu.annotation.SingletonComponent

@SingletonComponent
class RecommendatorImpl() : Recommendator {
    @InjectProperty
    private var person: String? = null

    override fun recommend() {
        println("$person said do git fetch first!!")
    }
}