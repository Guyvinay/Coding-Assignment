package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

//    Optional<Ticket> findByNumbers(List<List<Integer>> numbers);

	
}
