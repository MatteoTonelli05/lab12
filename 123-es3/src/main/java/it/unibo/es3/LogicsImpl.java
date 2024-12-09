package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LogicsImpl implements Logics{
    private ArrayList<String> buttons; 

    public LogicsImpl(int width) {
        buttons = new ArrayList<>(Collections.nCopies(width * width, " "));
        
        Random rd = new Random();
        for(int i=0; i<3; i++) {
            buttons.set(rd.nextInt(0,width*width), "*");
        }
    }

    @Override
    public ArrayList<String> buttons() {
        return buttons;
    }

}
