package com.riwi.taller2.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.taller2.entities.Event;
import com.riwi.taller2.repositories.EventRepository;
import com.riwi.taller2.services.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService{

    private final EventRepository objEventRepository;

    @Override
    public Event save(Event objEvent) {
        if (objEvent.getDate().isBefore(objEvent.getDateToday()) || objEvent.getCapacity() <= 0){
            return null;
        }else{
            return this.objEventRepository.save(objEvent);
        }
    }

    @Override
    public List<Event> getAll() {
        return this.objEventRepository.findAll();
    }

    @Override
    public Event getById(String id) {
        return this.objEventRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        Event event = this.objEventRepository.findById(id).orElseThrow();

        this.objEventRepository.delete(event);
    }

    @Override
    public Event update(Event objEvent) {
        return this.objEventRepository.save(objEvent);
    }

    @Override
    public Page<Event> findAllPaginate(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        Pageable objPage = PageRequest.of(page, size);

        return this.objEventRepository.findAll(objPage); 
    } 
}
