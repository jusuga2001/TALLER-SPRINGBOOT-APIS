package com.riwi.taller2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.taller2.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{
    public List<Event> findByName(String name);
} 
