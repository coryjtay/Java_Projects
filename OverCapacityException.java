package edu.orangecoastcollege.cs170.ctaylor82.finalexam;

public class OverCapacityException extends Exception {

	public OverCapacityException() {
		super("Capacity exceeded, too many passengers.");
	}

	public OverCapacityException(String custom) {
		super(custom);
	}
}
