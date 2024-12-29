package com.cg.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bus.Bus;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer>{

}
