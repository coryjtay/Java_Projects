package edu.orangecoastcollege.cs170.ctaylor82.finalexam;

import java.io.Serializable;
import java.text.NumberFormat;

public class Train extends PublicTransport implements Serializable {

	private double mFirstClassFare;

	public Train(double firstClassFare, String providerName, int passengers, int capacity, double baseFare)
			throws OverCapacityException {
		mFirstClassFare = firstClassFare;
		mProvider = providerName;
		mCapacity = capacity;
		mBaseFare = baseFare;
		setPassengers(passengers);
	}

	public double getFirstClassFare() {
		return mFirstClassFare;
	}

	public void setFirstClassFare(double firstClassFare) {
		mFirstClassFare = firstClassFare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(mFirstClassFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Train other = (Train) obj;
		if (Double.doubleToLongBits(mFirstClassFare) != Double.doubleToLongBits(other.mFirstClassFare))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return "Train [" + mProvider + ", " + mPassengers + " passengers, " + mCapacity + " capacity, "
				+ currency.format(mBaseFare) + " base fare, " + currency.format(mFirstClassFare) + " first class fare]";
	}

}
