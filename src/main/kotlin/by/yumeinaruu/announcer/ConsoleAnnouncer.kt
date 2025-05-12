package by.yumeinaruu.announcer

class ConsoleAnnouncer: Announcer {
    override fun announce(message: String) {
        println(message)
    }
}