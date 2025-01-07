package com.example.Theatre.service;

import com.example.Theatre.dao.TheatreRepository;
import com.example.Theatre.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    private TheatreRepository repository;

    @Autowired
    public TheatreService(TheatreRepository repository) {
        this.repository = repository;
    }

    public List<Theatre> getAllTheatres() {
        return repository.getAllTheatres();
    }

    public Theatre getTheatreById(int id) {
        return repository.getTheatreById(id);
    }

    public String addTheatre(Theatre theatre) {
        return repository.addTheatre(theatre);
    }

    public String updateTheatre(Theatre theater, int id) {
        return repository.updateTheatre(theater, id);
    }

    public String deleteTheatre(int id) {
        return repository.deleteTheatre(id);
    }
}
