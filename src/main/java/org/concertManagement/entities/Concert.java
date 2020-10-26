package org.concertManagement.entities;

import java.util.Date;
import java.util.UUID;

public class Concert {
    private UUID id;

    private String name;

    private String type;


    private UUID arena_id;

    private Date date;


    public Concert() {
        this.id = UUID.randomUUID();
    }

    public Concert(String name, String type, Arena arena, Date date) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.arena_id = arena.getId();
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getArena_id() {
        return arena_id;
    }

    public void setArena_id(UUID arena_id) {
        this.arena_id = arena_id;
    }

    public Date getDate() {
        return date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
