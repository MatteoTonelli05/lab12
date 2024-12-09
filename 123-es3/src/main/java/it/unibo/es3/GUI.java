package it.unibo.es3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {

    private final Logics logics;

    public GUI(int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        logics = new LogicsImpl(width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);

        logics.buttons().forEach(v -> {
			JButton jb = new JButton(String.valueOf(v));
            jb.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(final KeyEvent e) {
                }

                @Override
                public void keyPressed(final KeyEvent e) {
                    if(jb.getText() == "*" && e.getKeyCode() == 39 ) {
                        System.out.println("no");
                    }
                }

                @Override
                public void keyReleased(final KeyEvent e) {
                }
                
            });
			panel.add(jb);
			this.getContentPane().add(jb);
		});

        this.setVisible(true);
    }
    
}