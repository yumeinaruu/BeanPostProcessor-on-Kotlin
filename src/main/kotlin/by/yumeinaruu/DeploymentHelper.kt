package by.yumeinaruu

import by.yumeinaruu.annotation.MyAutowire
import by.yumeinaruu.announcer.Announcer
import by.yumeinaruu.factory.ObjectFactory
import by.yumeinaruu.git.GitHelper

class DeploymentHelper {

    @MyAutowire
    private val announcer: Announcer? = null

    @MyAutowire
    private val gitHelper: GitHelper? = null

    fun startDeployment(remoteServer: RemoteServer) {
        announcer?.announce("Deployment begin!")
        gitHelper?.command()
        buildImages(remoteServer)
        announcer?.announce("Deployment done, app can be tested")
    }

    private fun buildImages(remoteServer: RemoteServer) {
        println("Docker images successfully built. Deploy success")
    }
}