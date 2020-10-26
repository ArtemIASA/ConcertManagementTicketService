package org.concertManagement.controllers;


import org.concertManagement.entities.Ticket;
import org.concertManagement.entities.dto.FinancesDTO;
import org.concertManagement.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.UUID;


@RestController
@RequestMapping("services/tickets")
public class TicketController {
    private final TicketService ticketService;
    private static final String visitorURL = "http://localhost:8086/services/visitors";
    private static final String financesURL = "http://localhost:8087/services/finances";
    private static final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    @PostMapping
    public ResponseEntity<Void> buyTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
        int toAdd = ticket.getPrice();
        changeProfit(ticket.getConcert_id(), toAdd  );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> returnTicket(@RequestBody Ticket ticket){
        ticketService.deleteTicket(ticket);
        deleteVisitor(ticket.getVisitor_id());
        int toSubstract = -ticket.getPrice();
        changeProfit(ticket.getConcert_id(), toSubstract);
        return ResponseEntity.ok().build();
    }

    private void deleteVisitor(UUID visitor_id){
        HttpEntity<UUID> deleteVisitor = new HttpEntity<>(visitor_id);
        ResponseEntity<Void> response  = restTemplate.exchange(visitorURL, HttpMethod.DELETE, deleteVisitor, Void.class);
    }

    private void changeProfit(UUID concert_id, int price){
        FinancesDTO financesDTO = new FinancesDTO(concert_id, price);
        HttpEntity<FinancesDTO> changeProfit = new HttpEntity<>(financesDTO);
        ResponseEntity<Void> response  = restTemplate.exchange(financesURL, HttpMethod.POST, changeProfit, Void.class);
    }


}
