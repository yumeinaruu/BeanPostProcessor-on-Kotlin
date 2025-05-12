package by.yumeinaruu.recommendator

import by.yumeinaruu.annotation.InjectProperty

class RecommendatorImpl() : Recommendator {
    @InjectProperty
    private var person: String? = null

    override fun recommend() {
        println("$person said do git fetch first!!")
    }
}