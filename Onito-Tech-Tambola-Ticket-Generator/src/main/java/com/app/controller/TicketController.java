package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.modal.Ticket;
import com.app.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

	@Autowired
	private TicketService tambolaService;

	@PostMapping("/{numberOfSets}")
	public ResponseEntity<List<List<Ticket>>> generateSetOfTickets(@PathVariable("numberOfSets") int numberOfSets) {

		return new ResponseEntity<List<List<Ticket>>>(tambolaService.generateAndSaveTickets(numberOfSets),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> generateTickets() {

		return new ResponseEntity<Map<String, Object>>(tambolaService.generateTickets(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Ticket>> getAllTickets() {

		return new ResponseEntity<List<Ticket>>(tambolaService.getAllTickets(), HttpStatus.OK);
	}

	@GetMapping(value = "/{ticket_id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("ticket_id") String ticket_id) {

		return new ResponseEntity<Ticket>(tambolaService.getTicketById(ticket_id), HttpStatus.OK);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<List<Ticket>> getTicketsByPagination(
			@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10", name = "limit") Integer limit,
			@RequestParam(required = false, defaultValue = "DESC", name = "dir") String direction) {

		return new ResponseEntity<List<Ticket>>(tambolaService.getTicketsByPagination(page, limit, direction),
				HttpStatus.ACCEPTED);
	}

}
