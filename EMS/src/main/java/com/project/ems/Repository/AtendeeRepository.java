package com.project.ems.Repository;

import com.project.ems.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendeeRepository extends JpaRepository<Attendee, Long> {
}
