import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import roots.SpringMusicVcs
import tasks.BuildSpringMusic
import tasks.HelloWorld

version = "2021.1"

project {
    vcsRoot(SpringMusicVcs)
    buildType(HelloWorld)
    buildType(BuildSpringMusic)
}
