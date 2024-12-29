package com.cg.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bus.Reservation;
import com.cg.bus.service.ReservationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ReservationController {

	@Autowired
	ReservationService resSvc;

	@RequestMapping(value = "/addreservation", method = RequestMethod.POST)
	public String addReservation(@RequestBody Reservation reservation) {
		return resSvc.addReservation(reservation);
	}

	@RequestMapping(value = "/updatereservation", method = RequestMethod.PUT)
	public String updateReservation(@RequestBody Reservation reservation) {
		return resSvc.updateReservation(reservation);
	}

	@RequestMapping(value = "/deletereservation/{reservationid}", method = RequestMethod.DELETE)
	public String deleteReservation(@PathVariable("reservationid") int reservationid) {
		Reservation reservation  = resSvc.viewReservation(reservationid);
		reservation.setBusId(null);
		resSvc.updateReservation(reservation);
		return resSvc.deleteReservation(reservationid);
	}

	@RequestMapping(value = "/getreservationbyid/{reservationid}", method = RequestMethod.GET)
	public Reservation viewReservation(@PathVariable("reservationid") int reservationid) {
		return resSvc.viewReservation(reservationid);
	}

	@RequestMapping(value = "/getallreservation", method = RequestMethod.GET)
	public List<Reservation> viewAllReservation() {
		return resSvc.viewAllReservation();
	}

	@RequestMapping(value = "/getreservationbydate/{reservationdate}", method = RequestMethod.GET)
	public List<Reservation> getAllReservation(@PathVariable("reservationdate") String reservationdate) {
		return resSvc.getAllReservation(reservationdate);
	}
}
