package org.concertManagement.entities;

import java.util.UUID;


public class Arena {
    private UUID id;
    private String name;
    private String address;
    private int capacity;

    public Arena() {
        this.id = UUID.randomUUID();
    }

    public Arena(String name, String address, int capacity) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public UUID getId() {
        return id;
    }
}
