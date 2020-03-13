package com.example.bo;

public class Truck {
	
	private Integer truckId;
	private Float lattitude;
	private Float longitude;
	public Integer getTruckId() {
		return truckId;
	}
	public void setTruckId(Integer truckId) {
		this.truckId = truckId;
	}
	public Float getLattitude() {
		return lattitude;
	}
	public void setLattitude(Float lattitude) {
		this.lattitude = lattitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lattitude == null) ? 0 : lattitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((truckId == null) ? 0 : truckId.hashCode());
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
		Truck other = (Truck) obj;
		if (lattitude == null) {
			if (other.lattitude != null)
				return false;
		} else if (!lattitude.equals(other.lattitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (truckId == null) {
			if (other.truckId != null)
				return false;
		} else if (!truckId.equals(other.truckId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Truck [truckId=" + truckId + ", lattitude=" + lattitude + ", longitude=" + longitude + "]";
	}
	
	
	

}
