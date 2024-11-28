package com.springboot.postgres.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.postgres.api.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
}
