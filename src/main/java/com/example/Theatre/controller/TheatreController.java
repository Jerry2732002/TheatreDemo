package com.example.Theatre.controller;

import com.example.Theatre.entity.Theatre;
import com.example.Theatre.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    private final TheatreService service;

    @Autowired
    public TheatreController(TheatreService service) {
        this.service = service;
    }

    @GetMapping(path = "list", produces = "application/json")
    public List<Theatre> getAllTheatres() {
        return service.getAllTheatres();
    }

    @GetMapping(path = "get", produces = "application/json")
    public Theatre getTheatreById(@RequestParam("id") int id) {
        return service.getTheatreById(id);
    }

    @PostMapping(path = "add")
    public String addTheatre(@RequestBody Theatre theatre) {
        return service.addTheatre(theatre);
    }

    @PutMapping(path = "update")
    public String updateTheatre(@RequestBody Theatre theatre) {
        return service.updateTheatre(theatre, theatre.getId());
    }

    @DeleteMapping(path = "delete/{id}")
    public String deleteTheatre(@PathVariable("id") int id) {
        return service.deleteTheatre(id);
    }

    @PatchMapping(path = "partial_update")
    public String partialUpdate(@RequestBody Theatre theatre) {
        return service.updateTheatre(theatre, theatre.getId());
    }
}