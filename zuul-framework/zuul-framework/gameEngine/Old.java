package gameEngine;

import commands.Parser;
import player.Player;
import commands.Command;
import commands.CommandWord;

//TODO: work method -> inc money
public class Old extends Game {
    public Old(Player p1, Parser parser) {
        super(p1, parser, 20);
    }

    public void processCommand(Command command) {
        CommandWord commandWord = command.getCommandWord();
        switch(commandWord) {
            //case WORK -> System.out.println("You are too old to work");
            default -> super.processCommand(command);
        }
    }

}
