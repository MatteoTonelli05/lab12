package it.unibo.es2;

public interface Logics {
    /**
	 * @return the number of buttons (except Print)
	 */
	int size();
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	String hit(Pair<Integer, Integer> buttonPosition);
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit(Pair<Integer,Integer> buttonPosition);
}
