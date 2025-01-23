package com.project.ems.controller;

import com.project.ems.Repository.AtendeeRepository;
import com.project.ems.model.Attendee;
import com.project.ems.service.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    @Autowired
    public AtendeeRepository attendeeRepository;
    @Autowired
    private com.project.ems.service.emailService emailService;
//    private Long id;

    @GetMapping
    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }
    @PostMapping
    public String createAttendee(@RequestBody Attendee attendee) {
        attendeeRepository.save(attendee);
        return "Attendee created";
    }
    @GetMapping("/{id}/generate-qr")
    public ResponseEntity<String> generateQRCode(@PathVariable Long id) {
        Optional<Attendee> attendeeOptional = attendeeRepository.findById(id);

        if (attendeeOptional.isPresent()) {
            Attendee attendee = attendeeOptional.get();
            try {
                // Define QR code content
                String qrText = "http://localhost:8080/api/attendees/" + id + "/mark/attendance";

                // Generate file name: QR_<attendeeName>_<attendeeId>.png
                String sanitizedAttendeeName = attendee.getFirstName().replaceAll("[^a-zA-Z0-9]", "_");
                String fileName = "QR_" + sanitizedAttendeeName + "_" + id + ".png";

                BufferedImage img;

                // Generate QR code and save it in the "qrCodes" folder
                img=QRCodeGenerator.generateQRCodeImage(qrText, 200, 200, attendee.getFirstName(), id);

                emailService.sendEmail(attendee.getEmail(),"Qr code for attendee "+attendee.getFirstName(),"QR Code for attendee "+"QR"+"_"+attendee.getFirstName()+"_"+attendee.getId()+".png",img);

                return ResponseEntity.ok("QR code generated successfully for attendee ID " + id);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Error generating QR code: " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/mark/attendance")
    public ResponseEntity<String> markAttendance(@PathVariable Long id) {
        Optional<Attendee> attendee = attendeeRepository.findById(id);
        if (attendee.isPresent()) {
            Attendee attendee1 = attendee.get();
            attendee1.setAttendance("Y");
            attendeeRepository.save(attendee1);
            return ResponseEntity.ok("Attendance marked for "+attendee1.getFullName());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendee not found");
        }
    }


//    @PostMapping("/{id}/mark-attendance")
//    public ResponseEntity<String> markAttendance(@PathVariable Long id) {
////        this.id = id;
//        Optional<Attendee> attendeeOpt = attendeeRepository.findById(id);
//        if (attendeeOpt.isPresent()) {
//            Attendee attendee = attendeeOpt.get();
//            attendee.setAttendance("Y");
//            attendeeRepository.save(attendee);
//            return ResponseEntity.ok("Attendance marked for " + attendee.getFullName());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendee not found");
//        }
//    }
}
