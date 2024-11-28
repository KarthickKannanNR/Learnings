package com.springboot.postgres.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.postgres.api.dao.TicketDao;
import com.springboot.postgres.api.model.Ticket;

@RestController
@RequestMapping("/ticketController")
public class TicketController {
	@Autowired
	private TicketDao ticketDao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(List<Ticket> tickets) {
		ticketDao.saveAll(tickets);
		return null;
	}
	
	@GetMapping("/listTickets")
	public List<Ticket> listTicket(){
		return (List<Ticket>) ticketDao.findAll();
	}
}
