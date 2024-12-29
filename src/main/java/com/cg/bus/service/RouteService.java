package com.cg.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bus.Route;
import com.cg.bus.exception.RouteAlreadyExistException;
import com.cg.bus.exception.RouteNotFoundException;
import com.cg.bus.repository.IRouteRepository;

@Service
public class RouteService implements IRouteService {
	@Autowired
	IRouteRepository routerepo;

	@Override
	public String addRoute(Route route) {
		Optional<Route> rout = routerepo.findById(route.getRouteId());
		if(rout.isPresent()) {
			throw new RouteAlreadyExistException("The route with "+route.getRouteId()+" route id is already exist");
		}
		routerepo.save(route);
		return "Route Added Successfully";
	}

	@Override
	public String updateRoute(Route route) {
		Optional<Route> rout = routerepo.findById(route.getRouteId());
		if(rout.isPresent()) {
			routerepo.save(route);
			return "Route Updated Successfully";
		}
		else {
			throw new RouteNotFoundException("The route with "+route.getRouteId()+" route id is not exist");
		}
		
	}

	@Override
	public String deleteRoute(int routeid) {
		Optional<Route> route = routerepo.findById(routeid);
		if (!route.isPresent()) {
			throw new RouteNotFoundException("Route for this id " + routeid + " not found");
		} else {
			routerepo.deleteById(routeid);
			return "Record deleted Succesfully";
		}
	}

	@Override
	public Route viewRoute(int routeId) {
		Optional<Route> route = routerepo.findById(routeId);
		if(route.isPresent()) {
			return routerepo.findById(routeId).get();
		}
		else {
			throw new RouteNotFoundException("Route for this id " + routeId + " not found");
		}	
	}

	@Override
	public List<Route> viewAllRoute() {
		return routerepo.findAll();

	}

}