package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics{
    private ArrayList<String> buttons; 
    private int size;

    public LogicsImpl(int width) {
        this.size = width * width;
        buttons = new ArrayList<>(Collections.nCopies(this.size, " "));
        Random rd = new Random();
        for(int i=0; i<3; i++) {
            buttons.set(rd.nextInt(0,width*width), "*");
        }
    }

    @Override
    public ArrayList<String> buttons() {
        return buttons;
    }

    @Override
    public void hit() {
        ArrayList<Integer> tmp = new ArrayList<>();
        final int width =(int)Math.sqrt(size);
        for(int i=0; i<this.size; i++) {
            if(buttons.get(i) == "*") {
                tmp.add(i);
            }
        }
        updateButton(tmp,width);
    }

    private void updateButton(List<Integer> buttonToChange, int width) {
        buttonToChange.forEach(i -> {
            for(int y=-1; y<2 ; y++) {
                for(int x=-1; x<2 ; x++) {
                    int tmp = i+x+(y*width);
                    if(checkButton(tmp, size)) {
                        buttons.set(tmp, "*");
                    }
                }
            }
        });
        
    }

    private boolean checkButton(int index, int size) {
        if(index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    @Override
    public boolean toQuit() {
        return buttons.stream().distinct().count() == 1;
    }

}
