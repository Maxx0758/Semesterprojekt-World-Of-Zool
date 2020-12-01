package gameEngine;

import commands.Parser;
import player.Player;

public class Run {
    private Parser parser = new Parser();
    Player p1 = new Player();
    Child c = new Child(p1, parser);
    Adult a = new Adult(p1, parser);
    Old o = new Old(p1, parser);

    public Run() {
        new InitGame(p1, parser);

        while (p1.getAlive()) {
            switch (p1.getStage()) {
                case "child" -> c.play();
                case "adult" -> {p1.moveFamilyEconomy(); a.play();}
                case "old" -> o.play();
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
}