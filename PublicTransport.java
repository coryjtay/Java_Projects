package edu.orangecoastcollege.cs170.ctaylor82.finalexam;

import java.io.Serializable;

public abstract class PublicTransport implements Serializable {

	protected String mProvider;
	protected int mPassengers;
	protected int mCapacity;
	protected double mBaseFare;

	public String getProvider() {
		return mProvider;
	}

	public void setProvider(String provider) {
		mProvider = provider;
	}

	public int getPassengers() {
		return mPassengers;
	}

	public void setPassengers(int passengers) throws OverCapacityException {
		if (mPassengers > mCapacity)
			throw new OverCapacityException();
		mPassengers = passengers;
	}

	public int getCapacity() {
		return mCapacity;
	}

	public void setCapacity(int capacity) {
		mCapacity = capacity;
	}

	public double getBaseFare() {
		return mBaseFare;
	}

	public void setBaseFare(double baseFare) {
		mBaseFare = baseFare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(mBaseFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mCapacity;
		result = prime * result + mPassengers;
		result = prime * result + ((mProvider == null) ? 0 : mProvider.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublicTransport other = (PublicTransport) obj;
		if (Double.doubleToLongBits(mBaseFare) != Double.doubleToLongBits(other.mBaseFare))
			return false;
		if (mCapacity != other.mCapacity)
			return false;
		if (mPassengers != other.mPassengers)
			return false;
		if (mProvider == null) {
			if (other.mProvider != null)
				return false;
		} else if (!mProvider.equals(other.mProvider))
			return false;
		return true;
	}

}
