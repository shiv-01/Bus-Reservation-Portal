package com.cg.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bus.Bus;
import com.cg.bus.service.BusService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BusController {

	@Autowired BusService busservice;
	@RequestMapping(value="/getallbus",method=RequestMethod.GET)
	public java.util.List<Bus> getAllBus(){
		return busservice.viewAllBus();
	}
	
	 @RequestMapping(value = "/addbus", method=RequestMethod.POST)
	 public String addBus(@RequestBody Bus bus) {
		 return busservice.addBus(bus);
	 }
	 
	 @RequestMapping(value = "/getbusbyroute/{source}/{dest}",method=RequestMethod.GET)
	 public List<Bus> getBus(@PathVariable("source")String source,@PathVariable("dest") String dest ) {
	 	return busservice.viewBusByRoute(source,dest);
	 }
	 
	 @GetMapping(value = "/getbusbyroute/{source}/{dest}/{day}")
	 public List<Bus> getBus(@PathVariable("source")String source,@PathVariable("dest") String dest,@PathVariable String day ) {
		 	return busservice.viewBusByRouteAndDay(source,dest,day);
		 }

	 
	 @RequestMapping(value = "/delbus/{busid}", method = RequestMethod.DELETE)
	 public String deleteBus(@PathVariable("busid") int busid) {
		 return busservice.deleteBus(busid); 	 
	 }
	 
	 @RequestMapping(value = "/updbus", method=RequestMethod.PUT)
	 public String updateBus(@RequestBody Bus bus) {
		 return busservice.updateBus(bus);
	 }
	 
	 @RequestMapping(value = "/getbusbytype/{bustype}",method=RequestMethod.GET)
	 public List<Bus> getBus(@PathVariable("bustype")String bustype) {
	 	return busservice.viewBusByType(bustype);
	 }
}
