package org.deneme.organdoku;

import org.deneme.organdoku.screen.IntroScreen;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.io.IOException;

@SpringBootApplication
public class OrganDokuApplication implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(OrganDokuApplication.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) throws IOException {
        String welcome = "This ORGANDOKU program brings a brain teaser to you!\n"+
                "ORGANDOKU has two different game modes: GENERIC ORGANDOKU and org.deneme.organdoku.screen.DKA (DON'T KILL ANYBODY)\n"+
                "ORGANDOKU mode is very similar to generic sudoku structure, with some twist. For every completed 3x3 section,\n"+
                "(which are represented as PATIENTS),row and column, you will gain BONUS points:\n"+
                "3x3 SECTION = + 20 PTS\n"+
                "ROW & COLUMN = + 15 PTS\n"+
                "On the contrary, you will be penalized for every MISTAKE you will perform.\n"+
                "MISTAKE = - 5 PTS\n"+
                "If your score drops below - 50, YOU WILL SCREW UP!\n"+
                "org.deneme.organdoku.screen.DKA (DON'T KILL ANYBODY) mode is a crueler mode, which doesn't let you kill a PATIENT! \nWhich means, YOU CAN'T MAKE ANY MISTAKE!\n"+
                "Point regulation is the same for both modes.\n"+
                "ORGANDOKU provides a good-looking, sleek user interface and easy playability.";

        JOptionPane.showMessageDialog(new JFrame(), welcome);
        IntroScreen frame= new IntroScreen();


        //JFrame frame = new JFrame("Spring Boot Swing App");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300,300);
        //JPanel panel = new JPanel(new BorderLayout());
        //JTextField text = new JTextField("Spring Boot can be used with Swing apps");
        //panel.add(text, BorderLayout.CENTER);
        //frame.setContentPane(panel);
        //frame.setVisible(true);
    }
}