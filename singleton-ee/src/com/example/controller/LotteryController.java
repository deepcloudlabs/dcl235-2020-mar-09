package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.service.LotteryService;

@Path("numbers")
@RequestScoped
public class LotteryController {
	@Inject private LotteryService lotteryService;
	
	@PostConstruct
	public void init() {
		System.err.println("RestController is created!");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<List<Integer>> getNumbers(@QueryParam("n") int n){
		return lotteryService.draw(n);
	}
}