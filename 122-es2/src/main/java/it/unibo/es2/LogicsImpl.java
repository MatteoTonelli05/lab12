package it.unibo.es2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicsImpl implements Logics{
    
    private int size;
    private final Map<Pair<Integer, Integer>, String> buttons;

    public LogicsImpl(int size) {
        this.size = size;
        buttons = new HashMap<>();
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                this.buttons.put(new Pair<>(i,j)," ");
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String hit(Pair<Integer, Integer> buttonPosition) {
        buttons.put(buttonPosition, buttons.get(buttonPosition) == " " ? "*" : " ");
		return buttons.get(buttonPosition);
    }

    @Override
    public boolean toQuit(Pair<Integer,Integer> buttonPosition) {
        boolean quit = true;
        for(int i=0; i<size && quit; i++) {
            if( buttons.get(new Pair<Integer, Integer>(i, buttonPosition.getY())).equals(" ")) {
                quit = false;
            }
        }

        if(quit) {
            return quit;
        }
        
        quit = true;
        for(int i=0; i<size && quit; i++) {
            if( buttons.get(new Pair<Integer, Integer>(buttonPosition.getX(), i)).equals(" ")) {
                quit = false;
            }
        }

        return quit;
    }
    
}
