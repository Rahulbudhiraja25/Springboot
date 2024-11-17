package com.learn.DatraFetch.Repository;


import com.learn.DatraFetch.Entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Long> {
    List<Toy> findByName(String name);
}
