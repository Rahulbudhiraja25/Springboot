package com.learning.sb_gamerunner_first;

import com.learning.sb_gamerunner_first.game.GameRunner;
import com.learning.sb_gamerunner_first.game.MarioGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbGamerunnerFirstApplication{

	public static void main(String[] args) {
		SpringApplication.run(SbGamerunnerFirstApplication.class, args);


	var marioGame = new MarioGame();
	var gameRunner=new GameRunner(marioGame);
	gameRunner.run();

}
}