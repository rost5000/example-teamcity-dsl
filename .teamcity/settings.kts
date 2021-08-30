import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import some.other.HelloWorld

version = "2021.1"

project {
    buildType(HelloWorld)
}

