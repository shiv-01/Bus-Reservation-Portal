package com.cg.bus.service;

import java.util.List;

import com.cg.bus.Route;

public interface IRouteService {

		public String addRoute(Route route);
		public String updateRoute(Route route);
		public String deleteRoute(int routeid);
		public Route viewRoute(int routeId);
		public List<Route> viewAllRoute();
}
