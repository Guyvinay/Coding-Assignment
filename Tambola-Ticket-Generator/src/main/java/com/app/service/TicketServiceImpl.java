package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.app.exception.TicketNotFoundException;
import com.app.modal.Ticket;
import com.app.repository.TicketRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	// Generating N-set of tickets
	@Override
	public List<List<Ticket>> generateAndSaveTickets(int numberOfSets) {

		List<List<Ticket>> generatedTickets = new ArrayList<>();
		// getting list of N-tickets
		for (int i = 0; i < numberOfSets; i++) {
			List<Ticket> tickets = generateSetOfTickets();
			generatedTickets.add(tickets);
		}
		return generatedTickets;
	}

	// Generating a set of 6-tickets
	@Override
	public Map<String, Object> generateTickets() {

		Map<String, Object> map = new HashMap<>();

		List<Ticket> setOfTickets = generateSetOfTickets();
		for (Ticket ticket : setOfTickets) {
			map.put(ticket.getId(), ticket.getNumbers());
		}

		return map;
	}

	// generating set of 6 tickets
	public List<Ticket> generateSetOfTickets() {
		List<Ticket> ticketList = new ArrayList<>();

		// 6 tickets
		for (int i = 0; i < 6; i++) {
			Ticket ticket = generateRandomTicket();
			ticketList.add(ticket);
		}
		return ticketList;
	}

	// generating ticket;
	public Ticket generateRandomTicket() {

		List<List<Integer>> numList = new ArrayList<>();
		Ticket ticket = new Ticket();

		// each ticket should have 3 columns
		for (int i = 0; i < 3; i++) {
			List<Integer> rowIntegers = generateRandomRow();
			numList.add(rowIntegers);
		}

		Ticket savedTicket = ticketRepository.save(ticket);

		savedTicket.setNumbers(numList);

		return savedTicket;
	}

	private List<Integer> generateRandomRow() {

		List<Integer> row = new ArrayList<>();
		Random random = new Random();

		// generating random numbers for each row column-wise
		for (int i = 0; i < 9; i++) {
			int number = random.nextInt(10) + i * 10;
			row.add(number);
		}

		// row should contains 5-numbers, putting 0 to remaining 4 random cells
		for (int i = 0; i < 4; i++) {
			int indexRemove = random.nextInt(9);
			row.set(indexRemove, 0);
		}

		return row;
	}

	@Override
	public List<Ticket> getAllTickets() {
		List<Ticket> list = ticketRepository.findAll();
		if (list.isEmpty())
			throw new TicketNotFoundException("No tickets found!!!");
		log.info("total " + list.size() + ", found!!!");
		return list;
	}

	// Getting Tickets in Page
	@Override
	public List<Ticket> getTicketsByPagination(Integer page, Integer limit, String direction) {

//		PageRequest.of(page, limit, Sort.by(Direction.ASC, "id"));
		PageRequest pageRequest = PageRequest.of(page, limit, direction.equals("ASC") ? Direction.ASC : Direction.DESC,
				"id");
		Page<Ticket> pages = ticketRepository.findAll(pageRequest);
		List<Ticket> tickets = pages.getContent();
		log.info("total " + tickets.size() + ", found!!!");
		return tickets;
	}

	@Override
	public Ticket getTicketById(String ticket_id) {
		Ticket ticket = ticketRepository.findById(ticket_id)
				.orElseThrow(() -> new TicketNotFoundException("Ticket with id: " + ticket_id + ", not found!!!"));
		return ticket;
	}

}
