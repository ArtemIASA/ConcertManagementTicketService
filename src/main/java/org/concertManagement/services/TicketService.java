package org.concertManagement.services;


import org.concertManagement.entities.Ticket;
import org.concertManagement.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void addTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    @Transactional
    public void deleteTicket(Ticket ticket){
        ticketRepository.delete(ticket);
    }

}
