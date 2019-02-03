package com.tawanda.waveReloaded;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {


    Window (int width, int height,String title,Game game){
        JFrame jFrame = new JFrame(title);
        jFrame.setPreferredSize(new Dimension(width,height));
        jFrame.setMaximumSize(new Dimension(width, height));
        jFrame.setMinimumSize(new Dimension(width, height));

        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(game);
        jFrame.setVisible(true);
        game.start();

    }
}
