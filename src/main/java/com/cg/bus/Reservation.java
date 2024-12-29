package com.cg.bus;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reservationid")
	private int reservationId;
	@Column(name = "reservationstatus")
	private String reservationStatus;
	@Column(name = "reservationtype")
	private String reservationType;
	@Column(name = "reservationdate")
	private String reservationDate;
	@Column(name = "reservationtime")
	private String reservationTime;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;

	@ManyToOne
	@JoinColumn(name = "busid")
	private Bus bus;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Bus getBusId() {
		return bus;
	}

	public void setBusId(Bus bus) {
		this.bus = bus;
	}

	public Reservation() {

	}

	public Reservation(int reservationId, String reservationStatus, String reservationType, String reservationDate,
			String reservationTime, String source, String destination, Bus bus) {
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}

}
