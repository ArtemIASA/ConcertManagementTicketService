package org.concertManagement.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    private UUID id;

    @Column(name = "visitor_id")
    private UUID visitor_id;

    @Column(name = "concert_id")
    private UUID concert_id;

    @Column(name = "price")
    private int price;


    public Ticket() {
        this.id = UUID.randomUUID();
    }

    public Ticket(Visitor visitor, Concert concert, int price) {
        this.id = UUID.randomUUID();
        this.visitor_id = visitor.getId();
        this.concert_id = concert.getId();
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(UUID visitor_id) {
        this.visitor_id = visitor_id;
    }

    public UUID getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(UUID concert_id) {
        this.concert_id = concert_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}