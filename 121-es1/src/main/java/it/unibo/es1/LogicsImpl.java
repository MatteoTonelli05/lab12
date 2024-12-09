package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private int size;
	private ArrayList<Integer> buttonsHit;
	private ArrayList<Boolean> buttonsEnabled;

	public LogicsImpl(int size) {
		this.size = size;
		buttonsHit = new ArrayList<>(Collections.nCopies(size, 0));
		buttonsEnabled = new ArrayList<>(Collections.nCopies(size, true));
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<Integer> values() {
		return buttonsHit;
	}

	@Override
	public List<Boolean> enablings() {
		return buttonsEnabled;
	}

	@Override
	public int hit(int elem) {
		buttonsHit.set(elem, buttonsHit.get(elem) + 1);
		if( buttonsHit.get(elem) == this.size) {
			buttonsEnabled.set(elem, false);
		}
		return buttonsHit.get(elem);
	}

	@Override
	public String result() {
		return this.buttonsHit
			.stream()
			.map(Object::toString)
			.collect(Collectors.joining(",","<<",">>"));
	}

	@Override
	public boolean toQuit() {
		return buttonsHit
			.stream()
			.distinct()
			.count() == 1;
	}
}
