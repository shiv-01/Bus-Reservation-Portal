package com.cg.bus.service;

import java.util.List;

import com.cg.bus.Bus;

public interface IBusService {

	public String addBus(Bus bus);
	public String updateBus(Bus bus);
	public String deleteBus(int busid);
	public List<Bus> viewBusByRoute(String source,String dest);
	public List<Bus> viewBusByRouteAndDay(String source,String dest,String day);
	public List<Bus> viewBusByType(String type);
	public List<Bus> viewAllBus();
}
