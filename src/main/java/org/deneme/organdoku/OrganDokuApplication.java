package org.deneme.organdoku;

import org.deneme.organdoku.screen.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class OrganDokuApplication implements ApplicationRunner {
    private final Game game;

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrganDokuApplication.class).headless(false).run(args);
    }

    @Autowired
    public OrganDokuApplication(Game game) {
        this.game = game;
    }

    @Override
    public void run(ApplicationArguments args) {
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300,300);
        //JPanel panel = new JPanel(new BorderLayout());
        //JTextField text = new JTextField("Spring Boot can be used with Swing apps");
        //panel.add(text, BorderLayout.CENTER);
        //frame.setContentPane(panel);
        //frame.setVisible(true);
    }
}