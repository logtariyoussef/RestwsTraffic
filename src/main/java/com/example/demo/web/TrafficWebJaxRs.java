package com.example.demo.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.demo.entities.Traffic;
import com.example.demo.repository.TrafficRepository;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Component
@Path("/traffic")
public class TrafficWebJaxRs { 
	@Autowired
	private TrafficRepository trafficRepo;
	//get list of traffic
    @Path("/getAll")	
 	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Traffic> trafficList(){
		return trafficRepo.findAll();
	}
	//get list with id
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Traffic getTraffic(@PathParam("id") Long id){
		return trafficRepo.findById(id).orElseThrow();
	}	
	//get traffic by gouv
	@Path("/getByGouv/{gouv}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Traffic> getTrafficByGouv(@PathParam("gouv") String gouv) {
	    // Use the received 'gouv' parameter to retrieve traffic by gouvernorat
	    if (gouv != null && !gouv.isEmpty()) {
	        return trafficRepo.findByGouv(gouv);
	    } else {
	        // Handle the case where the 'gouv' parameter is missing or empty
	        return Collections.emptyList();
	    }
	}
	//create traffic
	@Path("/create")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Traffic trafficCreate(Traffic traffic){
		return trafficRepo.save(traffic);
	}	
	//update traffic
	@Path("/update/{id}")
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	public Traffic trafficUpdate(Traffic traffic,@PathParam("id") Long id){
		traffic.setId(id);
		return trafficRepo.save(traffic);
	}
	//delete traffic
	@Path("/delete/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public void trafficDelete(@PathParam("id") Long id){	
	 trafficRepo.deleteById(id);
	}
	
	
}
