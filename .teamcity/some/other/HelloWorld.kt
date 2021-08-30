package some.other

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object HelloWorld : BuildType({
    name = "Hello world"
    steps {
        script {
            scriptContent = "echo 'Hello world! v2.0'"
        }
    }
})