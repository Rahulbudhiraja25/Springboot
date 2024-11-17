package com.project.LoginModule.Repository;

import com.project.LoginModule.Entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    // Custom query methods can be added here
    LoginUser findByEmail(String email);  // Example of a custom method to find a user by email

}

