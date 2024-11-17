package org.deneme.organdoku.screen;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Panel extends JPanel { //implements Runnable{
    Thread gameThread;
    public Panel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //setPreferredSize(new Dimension(100, 100));
        //setBackground(Color.WHITE);
        //setDoubleBuffered(true);
    }
}
