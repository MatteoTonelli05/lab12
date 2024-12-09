package it.unibo.es3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {

    private final Logics logics;
    private JPanel panel;

    public GUI(int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        logics = new LogicsImpl(width);
        panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(BorderLayout.CENTER,panel);

        update();

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
            }

            @Override
            public void keyPressed(final KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                    logics.hit();
                    update();
                    if (logics.toQuit()){ // here call the logic instead, to know if should exit!
                        System.exit(1);
                    } 
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
            }
            
        });
    }

    private void update() {
        panel.removeAll();
        logics.buttons().forEach(v -> {
			final JButton jb = new JButton(String.valueOf(v));
            jb.setFocusable(false);
			panel.add(jb);
		});
        
        this.setVisible(true);
    }
    
}