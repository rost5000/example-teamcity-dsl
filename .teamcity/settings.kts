import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import roots.SpringMusicVcs
import some.other.HelloWorld

version = "2021.1"

project {
    vcsRoot(SpringMusicVcs)
    buildType(HelloWorld)
    buildType(BuildSpringMusic)
}

object BuildSpringMusic : BuildType({
    name = "Build spring music"
    artifactRules = "build/libs"
    vcs {
        root(SpringMusicVcs)
    }

    steps {
        gradle {
            tasks = "clean build"
            useGradleWrapper = true
        }
    }
})


