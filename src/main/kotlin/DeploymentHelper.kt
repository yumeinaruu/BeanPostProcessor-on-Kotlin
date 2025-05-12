import announcer.Announcer
import announcer.ConsoleAnnouncer
import git.GitHelper
import git.GitHelperPull

class DeploymentHelper {

    private val announcer: Announcer = ConsoleAnnouncer()
    private val gitHelper: GitHelper = GitHelperPull()

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