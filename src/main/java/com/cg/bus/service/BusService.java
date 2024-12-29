package com.cg.bus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bus.Bus;
import com.cg.bus.exception.BusAlreadyExistException;
import com.cg.bus.exception.BusNotFoundException;
import com.cg.bus.repository.IBusRepository;

@Service
public class BusService implements IBusService {

	@Autowired IBusRepository busrepo;

	@Override
	public String deleteBus(int busid){
		Optional<Bus> bus = busrepo.findById(busid);
		if(bus.isPresent()) {
			busrepo.deleteById(busid);
			return "Record deleted Successfully";
		}
		else {
			throw new BusNotFoundException("Record for this bus id is not found");
		}
	}

	@Override
	public List<Bus> viewBusByType(String type) {
		List<Bus> list = new ArrayList<Bus>();
		list = busrepo.findAll().stream().filter(e->e.getBusType().equals(type)).toList();
		if(list.size() == 0) {
			throw new BusNotFoundException("Bus for "+type+" type is not found");
		}
		return list;
	}

	@Override
	public List<Bus> viewAllBus() {
		return busrepo.findAll();
	}

	@Override
	public String addBus(Bus bus) {
		Optional<Bus> b = busrepo.findById(bus.getBusId());
		if(b.isPresent()) {
			throw new BusAlreadyExistException("Bus with this "+bus.getBusId()+" bus id is already exist");
		}
		else {
		busrepo.save(bus);
		return "Record Added Successfully";
		}
	}

	@Override
	public String updateBus(Bus bus) {
		Optional<Bus> b = busrepo.findById(bus.getBusId());
		if(b.isPresent()) {
			busrepo.save(bus);
			return "Record Updated Successfully";
		}
		else {
			throw new BusNotFoundException("This bus record is not found");
		}
	}

	@Override
	public List<Bus> viewBusByRoute(String source,String dest) {
		List<Bus> buses =  busrepo.findAll().stream().filter(e->e.getRouteFrom().equalsIgnoreCase(source)&&e.getRouteTo().equalsIgnoreCase(dest)).toList();
		if(buses.size()!=0) {
			return buses;
		}
		else {
			throw new BusNotFoundException("No Bus available for this route");
		}
	}

	@Override
	public List<Bus> viewBusByRouteAndDay(String source, String dest, String day) {
		List<Bus> buses =  busrepo.findAll().stream().filter(e->e.getRouteFrom().equalsIgnoreCase(source)&&e.getRouteTo().equalsIgnoreCase(dest)&&e.getDay().equalsIgnoreCase(day)).toList();
		if(buses.size()!=0) {
			return buses;
		}
		else {
			throw new BusNotFoundException("No Bus available for this route on this day");
		}
			}

}
