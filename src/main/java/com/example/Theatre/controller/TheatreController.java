package com.example.Theatre.controller;

import com.example.Theatre.entity.Theatre;
import com.example.Theatre.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheatreController {

    private final TheatreService service;

    @Autowired
    public TheatreController(TheatreService service) {
        this.service = service;
    }

    @GetMapping(path = "theatre", produces = "application/json")
    public List<Theatre> getAllTheatres() {
        return service.getAllTheatres();
    }

    @GetMapping(path = "theatre/{id}", produces = "application/json")
    public Theatre getTheatreById(@PathVariable("id") int id) {
        return service.getTheatreById(id);
    }

    @PostMapping(path = "theatre")
    public String addTheatre(@RequestBody Theatre theatre) {
        return service.addTheatre(theatre);
    }

    @PutMapping(path = "theatre/{id}")
    public String updateTheatre(@RequestBody Theatre theatre, @PathVariable("id") int id) {
        return service.updateTheatre(theatre, id);
    }

    @DeleteMapping(path = "theatre/{id}")
    public String deleteTheatre(@PathVariable("id") int id) {
        return service.deleteTheatre(id);
    }

    @PatchMapping(path = "theatre/{id}")
    public String partialUpdate(@RequestBody Theatre theatre, @PathVariable("id") int id) {
        return service.updateTheatre(theatre, id);
    }
}