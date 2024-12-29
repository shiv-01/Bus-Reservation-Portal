package com.cg.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bus.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer> {

}
