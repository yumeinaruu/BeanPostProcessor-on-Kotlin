package by.yumeinaruu.announcer

import by.yumeinaruu.factory.ObjectFactory
import by.yumeinaruu.recommendator.Recommendator

class ConsoleAnnouncer: Announcer {

    private val recommendator: Recommendator = ObjectFactory.getInstance().createBean(Recommendator::class.java)

    override fun announce(message: String) {
        recommendator.recommend()
        println(message)
    }
}