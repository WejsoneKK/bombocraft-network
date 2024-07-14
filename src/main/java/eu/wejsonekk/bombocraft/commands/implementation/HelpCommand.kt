package eu.wejsonekk.bombocraft.commands.implementation

import dev.rollczi.litecommands.annotations.command.Command
import dev.rollczi.litecommands.annotations.execute.Execute

@Command(name = "help")
class HelpCommand {

    @Execute
    fun executeHelp() {
        // Execute the /help
    }

}
