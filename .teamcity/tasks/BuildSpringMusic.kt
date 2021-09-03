package tasks

import jetbrains.buildServer.configs.kotlin.v2018_1.ui.replaceVcsRoot
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
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
        dockerCommand {
            name = "docker-build"
            commandType = build {
                source = content {
                    content = """
                FROM openjdk:11-jre-slim
                
                COPY build/libs/34990ec62e052fcf-1.0.jar application.jar
                
                CMD "java -jar ./application.jar"
            """.trimIndent()
                }
                namesAndTags = "%registryUrl%/ex/example:latest"
                commandArgs = "--pull"
            }
        }
        dockerCommand {
            name = "docker-push"
            commandType = push{
                namesAndTags = "%registryUrl%/ex/example:latest"
            }
        }
    }
})


