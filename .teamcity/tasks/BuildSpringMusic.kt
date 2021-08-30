package tasks

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.gradle
import roots.SpringMusicVcs

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


