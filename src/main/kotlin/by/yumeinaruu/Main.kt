package by.yumeinaruu

import by.yumeinaruu.factory.ObjectFactory

fun main() {
    val deploymentHelper = ObjectFactory.getInstance().createBean(DeploymentHelper::class.java)
    deploymentHelper.startDeployment(RemoteServer())
}