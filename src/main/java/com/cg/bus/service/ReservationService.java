package com.cg.bus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bus.Bus;
import com.cg.bus.Reservation;
import com.cg.bus.exception.ReservationAlreadyExist;
import com.cg.bus.exception.UserNotFoundException;
import com.cg.bus.repository.IReservationRepository;

@Service
public class ReservationService {

	@Autowired
	IReservationRepository resRepo;

	public String addReservation(Reservation reservation) {
		Optional<Reservation> res = resRepo.findById(reservation.getReservationId());
		if(res.isPresent()) {
			throw new ReservationAlreadyExist("Reservation for "+reservation.getReservationId()+" reservation id already exist");
		}
		else {
		resRepo.save(reservation);
		Bus bus = reservation.getBusId();
		bus.setAvaiableSeats(bus.getAvaiableSeats() - 1);
		return "Reservation Done successfully";
		}
	}

	public String updateReservation(Reservation reservation) {
		Optional<Reservation> res = resRepo.findById(reservation.getReservationId());
		if(res.isPresent()) {
			resRepo.save(reservation);
			return "Reservation Updated successfully";
		}
		else {
			throw new UserNotFoundException("This reservation is nott found");
		}
		
	}

	public String deleteReservation(int reservationId) {
		Optional<Reservation> res = resRepo.findById(reservationId);
		if (res.isPresent()) {
			resRepo.deleteById(reservationId);
			Bus bus = res.get().getBusId();
			bus.setAvaiableSeats(bus.getAvaiableSeats() + 1);
			return "Reservation Cancelled successfully";
		} else
			throw new UserNotFoundException("Reservation for "+reservationId+" reservation id is not found");
	}

	public Reservation viewReservation(int reservationId) {
		Optional<Reservation> res = resRepo.findById(reservationId);
		if(res.isPresent()) {
			return resRepo.findById(reservationId).get();
		}
		else {
			throw new UserNotFoundException("Reservation for "+reservationId+" reservation id is not found");
		}
		
	}

	public List<Reservation> viewAllReservation() {
		return resRepo.findAll();
	}

	// get All reservation by date
	public List<Reservation> getAllReservation(String date) {
		List<Reservation> resList = new ArrayList<Reservation>();
		resList = resRepo.findAll().stream().filter(e -> e.getReservationDate().equals(date)).toList();
		return resList;
	}
}
