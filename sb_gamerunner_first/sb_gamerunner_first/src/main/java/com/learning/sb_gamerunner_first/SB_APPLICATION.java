package com.learning.sb_gamerunner_first;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SB_APPLICATION {
    public static void main (String args[]){
        var context =new AnnotationConfigApplicationContext(
                SB_CONFIGURATION.class
        );
    }

}
