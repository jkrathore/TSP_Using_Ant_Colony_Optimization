package com.tsp.aco;

public class city {
	private static final double EARTH_EQUATORIAL_RADIOUS = 6378.13700;
	private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI/1880;
	private static final double CONVERT_KM_TO_MILES = 0.621371;
	private double longitude;
	private double latitude;
	private String name;
	public String getname() {return name;}
	public City(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
		this.longitude = longitude * CONVERT_DEGREES_TO_RADIANS;

	}
	public double measureDistance(City city) {
		double deltaLongitude = (city.getLongitude() - this.getLongitude());
		double deltaLatitude = (city.getLatitude() - this.getLatitude());
		double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) +
				Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
		return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIOUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
	}
	public double getLatitude() { return this.latitude;}
	public double getLongitude() {return this.longitude;}
	public String toString() {
		return name;
	}

}
