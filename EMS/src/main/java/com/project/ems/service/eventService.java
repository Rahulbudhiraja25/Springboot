    package com.project.ems.service;

//    package com.project.ems.service;

    import com.project.ems.Repository.EventRepository;
    import com.project.ems.model.Event;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class eventService {

        @Autowired
        private EventRepository eventRepository;

        // Create Event
        public String createEvent(Event event) {
            eventRepository.save(event);
            return "Event created";
        }

        // Get All Events

        public List<Event> getAllEvents() {
//            EventResponseWrapper responseWrapper = new EventResponseWrapper();
//            responseWrapper.setEVENT();
            return eventRepository.findAll();
        }

        public String deleteEvent(long id) {
            eventRepository.deleteById(id);
            return "Event deleted";
        }

        public String updateEvent(long id, Event event) {
            event.setEventId(id);
            eventRepository.save(event);
            return "Event updated";
        }
    }

