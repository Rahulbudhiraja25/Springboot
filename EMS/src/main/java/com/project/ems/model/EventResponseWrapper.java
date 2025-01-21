package com.project.ems.model;

//package com.project.ems.model;

import jakarta.persistence.Entity;

import java.util.List;

//@Entity
public class EventResponseWrapper {

    private List<Event> Event;

    public List<Event> getEVENT() {
        return Event;
    }

    public void setEVENT(List<Event> EVENT) {
        this.Event = EVENT;
    }
}
