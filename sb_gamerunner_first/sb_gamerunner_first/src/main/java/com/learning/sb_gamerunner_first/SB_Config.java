package com.learning.sb_gamerunner_first;//package com.learning.sb_gamerunner_first;

import com.learning.sb_gamerunner_first.game.GameRunner;
import com.learning.sb_gamerunner_first.game.MarioGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SB_Config{
    public static void main(String args[]){
        var context =new AnnotationConfigApplicationContext(
                SB_CONFIGURATION.class
        );
}
}