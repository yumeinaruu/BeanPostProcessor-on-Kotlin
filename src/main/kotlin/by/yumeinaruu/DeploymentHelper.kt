package by.yumeinaruu

import by.yumeinaruu.announcer.Announcer
import by.yumeinaruu.factory.ObjectFactory
import by.yumeinaruu.git.GitHelper

class DeploymentHelper {

    private val announcer: Announcer = ObjectFactory.getInstance().createBean(Announcer::class.java)
    private val gitHelper: GitHelper = ObjectFactory.getInstance().createBean(GitHelper::class.java)

    fun startDeployment(remoteServer: RemoteServer) {
        announcer.announce("Deployment begin!")
        gitHelper.command()
        buildImages(remoteServer)
        announcer.announce("Deployment done, app can be tested")
    }

    private fun buildImages(remoteServer: RemoteServer) {
        println("Docker images successfully built. Deploy success")
    }
}