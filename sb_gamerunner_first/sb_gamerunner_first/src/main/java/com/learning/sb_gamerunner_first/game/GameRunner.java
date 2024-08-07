package com.learning.sb_gamerunner_first.game;

public class GameRunner {
    GamingConsole game;

public GameRunner(GamingConsole game){
    this.game =game;
}
public void run(){
    System.out.println("Running game "+ game);
    game.up();
    game.left();
    game.down();
    game.right();
}

}
