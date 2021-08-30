package roots

import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object SpringMusicVcs : GitVcsRoot({
    name = "SpringMusicVcs"
    url = "https://github.com/cloudfoundry-samples/spring-music.git"
})