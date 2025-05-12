package by.yumeinaruu.git

class GitHelperReset: GitHelper {
    override fun command() {
        println("git reset origin/prod")
    }

}