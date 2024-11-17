package org.deneme.organdoku;

import org.deneme.organdoku.screen.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class SudokuApplication implements ApplicationRunner {
    private final Game game;

    public static void main(String[] args) {
        new SpringApplicationBuilder(SudokuApplication.class).headless(false).run(args);
    }

    @Autowired
    public SudokuApplication(Game game) {
        this.game = game;
    }

    @Override
    public void run(ApplicationArguments args) {
        int height = game.getGraphicsConfiguration().getBounds().height/2;
        int width = game.getGraphicsConfiguration().getBounds().width/2;

        game.setTitle("ORGANDOKU v.1.0");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(width,height);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}