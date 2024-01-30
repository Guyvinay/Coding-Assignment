package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.modal.Ticket;

public interface TicketService {
	
	public List<List<Ticket>> generateAndSaveTickets(int numberOfSets);
	
	public Map<String, Object> generateTickets();
	
	public Ticket getTicketById(String ticket_id);
	
	public List<Ticket> getAllTickets();
	
	public List<Ticket> getTicketsByPagination(Integer page, Integer limit, String direction);
}
