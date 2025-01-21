package com.project.ems.controller;

import com.project.ems.service.eventService;
import com.project.ems.model.Event;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
public class EventController {

    @Autowired
    eventService eventService;
    @Autowired
    private HttpServletResponse response;

    @PostMapping("/create/event")
    public String createEvent(@RequestBody Event event) {
    return eventService.createEvent(event);
    }

    @GetMapping("/get/event")
    public Map<String, Object> getEvents() {

        List<Event> events=eventService.getAllEvents();
        Map<String,Object> map=new HashMap<>();
        map.put("Event",events);
        return map;

        //       return eventService.getAllEvents();
    }

    @DeleteMapping("/delete/event")
    public String deleteEvent(@RequestParam Long id) {
        return eventService.deleteEvent(id);
    }

    @PostMapping("/update")
    public String updateEvent(@RequestParam Long id , @RequestBody Event event) {
        return eventService.updateEvent(id,event);
    }
}
