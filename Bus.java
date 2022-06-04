package edu.orangecoastcollege.cs170.ctaylor82.finalexam;

import java.io.Serializable;
import java.text.NumberFormat;

public class Bus extends PublicTransport implements Serializable {

	private int mHorsepower;

	public Bus(int horsepower, String providerName, int passengers, int capacity, double baseFare)
			throws OverCapacityException {
		mHorsepower = horsepower;
		mProvider = providerName;
		mCapacity = capacity;
		mBaseFare = baseFare;
		setPassengers(passengers);
	}

	public int getHorsepower() {
		return mHorsepower;
	}

	public void setHorsepower(int horsepower) {
		mHorsepower = horsepower;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mHorsepower;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (mHorsepower != other.mHorsepower)
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return "Bus [" + mProvider + ", " + mPassengers + " passengers, " + mCapacity + " capacity, "
				+ currency.format(mBaseFare) + " base fare, " + mHorsepower + " HP]";
	}

}
