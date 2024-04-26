package com.riwi.taller2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.taller2.entities.Event;
import com.riwi.taller2.services.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventController {
    
    @Autowired
    private final IEventService objIEventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(this.objIEventService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> get(@PathVariable String id){
        return ResponseEntity.ok(this.objIEventService.getById(id)) ;
    }

    @PostMapping
    public ResponseEntity<Event> insert(@RequestBody Event objEvent){
        return ResponseEntity.ok(this.objIEventService.save(objEvent));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(
        @RequestBody Event objEvent,  /*para obtener los datos actualizados */
        @PathVariable String id    /* Obtener el id que viene en URL */
        ){
            objEvent.setId(id);
            return ResponseEntity.ok(this.objIEventService.update(objEvent));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIEventService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping(path = "/page")
    public ResponseEntity<Page<Event>> listAll(@RequestParam(defaultValue = "1") int Page, @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(this.objIEventService.findAllPaginate(Page -1, size));
    }
    
}
