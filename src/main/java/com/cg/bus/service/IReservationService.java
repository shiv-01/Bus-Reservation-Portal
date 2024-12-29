package com.cg.bus.service;

import java.util.List;

import com.cg.bus.Reservation;

public interface IReservationService {
	public String addReservation(Reservation reservation);
	public String updateReservation(Reservation reservation);
	public String deleteReservation(int reservationId);
	public Reservation viewReservation(int reservationId);
	public List<Reservation> viewAllReservation();
	public List<Reservation> getAllReservation(String date);
	}
