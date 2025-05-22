ModsDotGroovy.make {
    modLoader = 'javafml'
    loaderVersion = '[50,)'
    clientSideOnly = true

    license = 'MIT'
    issueTrackerUrl = 'https://github.com/PaintNinja/SpammyCombat/issues'

    mod {
        modId = 'spammycombat'
        displayName = 'SpammyCombat'
        version = this.version
        author = 'Paint_Ninja'
        description = 'A mod that aims to restore the old click spamming combat from Minecraft 1.8 and older.'
        displayUrl = 'https://www.curseforge.com/minecraft/mc-mods/spammycombat'

        dependencies {
            forge = '>=55.0.20'
            minecraft = '[1.21.5,1.22)'
        }
    }
}
