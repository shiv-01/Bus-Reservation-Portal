package com.cg.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bus.Route;
@Repository
public interface IRouteRepository extends JpaRepository<Route, Integer>{

}
