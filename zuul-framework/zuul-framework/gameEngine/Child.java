package gameEngine;

import commands.Command;
import commands.CommandWord;
import commands.Parser;
import item.Book;
import item.Item;
import player.Player;

import java.util.List;

//TODO: readBook method der sætter spillerens knowledge points ud fra bogen
//TODO: work method -> inc money
public class Child extends Game {
    public Child(Player p1, Parser parser) {
        super(p1, parser, 60);
    }

    public void play() {
        parser = new Parser();
        Command command = parser.getCommand();
        processCommand(command);
    }

    public boolean processCommand(Command command) {
        CommandWord commandWord = command.getCommandWord();
        switch(commandWord) {
            case MONEY -> System.out.println("You have " + super.getPlayer().getMoney() + " gold");
            case READ -> {readBook(); super.turns.decTurns(10);}
            case WORK -> work(7);
            default -> super.processCommand(command);
        }
        return true;
    }

    //TODO: Player inventory removeItem method
    //Todo: Player inventory should be of Item type and not String
    //TODO: Player needs knowledgePoints attribute, and mutator and accessor methods

    // Read the first book in your inventory, if any
    public void readBook() {
        if(!inPlace("school"))
            return;
        if(getPlayer().getSickness()!=null){
            System.out.println("You can't study while sick");
            return;
        }

        List<Item> inventory = super.getPlayer().getInventory();
        boolean hasBook = false;
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item instanceof Book) {
                hasBook = true;
                int bookKnowledgePoints = ((Book)item).getKNOWLEDGEPOINTS();
                super.getPlayer().incKnowledge(bookKnowledgePoints);
                super.getPlayer().removeInventoryItem(item);
                System.out.println("You read a book that gave you " + bookKnowledgePoints + " knowledge points");
                break;
            }
        }
        if (!hasBook) {
            System.out.println("You do not have a book in your inventory");
        }
    }
}