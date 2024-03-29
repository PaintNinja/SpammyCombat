ModsDotGroovy.make {
    modLoader = 'javafml'
    loaderVersion = '[49,)'

    license = 'MIT'
    issueTrackerUrl = 'https://github.com/PaintNinja/SpammyCombat/issues'

    mod {
        modId = 'spammycombat'
        displayName = 'SpammyCombat'
        version = this.version
        author = 'Paint_Ninja'
        description = 'A mod that aims to restore the old click spamming combat from Minecraft 1.8 and older.'
        displayUrl = 'https://www.curseforge.com/minecraft/mc-mods/spammycombat'

        displayTest = DisplayTest.IGNORE_ALL_VERSION

        dependencies {
            forge = '>=49.0.30'
            minecraft = '[1.20.4,1.21)'
        }
    }
}
