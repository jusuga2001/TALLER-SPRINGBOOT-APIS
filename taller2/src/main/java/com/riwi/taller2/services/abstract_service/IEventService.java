package com.riwi.taller2.services.abstract_service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.taller2.entities.Event;

public interface IEventService {
    public Event save(Event objEvent);

    public List<Event> getAll();

    public Event getById(String id);

    public void delete(String id);

    public Event update(Event objEvent);

    public Page<Event> findAllPaginate(int page, int size);
}
