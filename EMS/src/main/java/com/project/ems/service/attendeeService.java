package com.project.ems.service;


import com.project.ems.Repository.AtendeeRepository;
import com.project.ems.Repository.EventRepository;
import com.project.ems.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class attendeeService {

    @Autowired
    AtendeeRepository atendeeRepository;

    public String addAttendee(Attendee attendee) {

        atendeeRepository.save(attendee);
        return "Attendee added successfully";
    }

    public String deleteAttendee(Attendee attendee) {

        atendeeRepository.delete(attendee);
        return "Attendee deleted successfully";
    }
    public String updateAttendee( long id,Attendee attendee) {
        attendee
                .setId(id);
        atendeeRepository.save(attendee);
        return "Attendee updated successfully at id " + id;
    }

    public List<Attendee> getAllAttendee() {
        return atendeeRepository.findAll();
    }

    public Attendee getAttendeeById(long id) {
        return atendeeRepository.findById(id).get();
    }

}
