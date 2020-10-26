package org.concertManagement.entities.dto;

import java.util.UUID;

public class FinancesDTO {
    UUID concert_id;
    int toAdd;

    public FinancesDTO(){

    }

    public FinancesDTO(UUID concert_id, int toAdd) {
        this.concert_id = concert_id;
        this.toAdd = toAdd;
    }

    public UUID getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(UUID concert_id) {
        this.concert_id = concert_id;
    }

    public int getToAdd() {
        return toAdd;
    }

    public void setToAdd(int toAdd) {
        this.toAdd = toAdd;
    }
}
