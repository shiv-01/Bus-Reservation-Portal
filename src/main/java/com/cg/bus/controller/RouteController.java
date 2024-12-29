package com.cg.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bus.Route;
import com.cg.bus.exception.RouteNotFoundException;
import com.cg.bus.service.RouteService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RouteController {
	@Autowired
	RouteService routeservice;

	@RequestMapping(value = "/getallroute", method = RequestMethod.GET)
	public java.util.List<Route> getAllBus() {
		return routeservice.viewAllRoute();
	}

	@RequestMapping(value = "/addroute", method = RequestMethod.POST)
	public String addRoute(@RequestBody Route route) {
		return routeservice.addRoute(route);
	}

	@RequestMapping(value = "/delroute/{routeid}", method = RequestMethod.DELETE)
	public String deleteRoute(@PathVariable("routeid") int routeid) {
		Route route  = routeservice.viewRoute(routeid);
		route.setBus(null);
		routeservice.updateRoute(route);
		return routeservice.deleteRoute(routeid);
	}

	@RequestMapping(value = "/updroute", method = RequestMethod.PUT)
	public String updateRoute(@RequestBody Route route) {
		Route rout = routeservice.viewRoute(route.getRouteId());
		if(rout == null) {
			throw new RouteNotFoundException("This route does not exist");
		}
		return routeservice.updateRoute(route);
	}

	@RequestMapping(value = "/getroutebyid/{routeid}", method = RequestMethod.GET)
	public Route getRoute(@PathVariable("routeid") int routeid) {
		return routeservice.viewRoute(routeid);
	}
}