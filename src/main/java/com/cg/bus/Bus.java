package com.cg.bus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bus")

public class Bus {
	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			String day, String arrivalTime, String departureTime, int seats, int avaiableSeats) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.day = day;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
	}

	@Id
	@Column(name="busid")
	private int busId;
	@Column(name="busname")
	private String busName;
	@Column(name="drivername")
	private String driverName;
	@Column(name="bustype")
	private String busType;
	@Column(name="routefrom")
	private String routeFrom;
	@Column(name="routeto")
	private String routeTo;
	@Column(name="Day")
	private String day;
	@Column(name="arrivaltime")
	private String arrivalTime;
	@Column(name="departuretime")
	private String departureTime;
	@Column(name="seats")
	private int seats;
	@Column(name="availableseats")
	private int avaiableSeats;
	
	public Bus() {
		
	}


	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvaiableSeats() {
		return avaiableSeats;
	}

	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	

}
