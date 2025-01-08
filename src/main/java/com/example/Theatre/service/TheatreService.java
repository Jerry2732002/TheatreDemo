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

    public String updateTheatre(Theatre theatre, int id) {
        Theatre original = getTheatreById(theatre.getId());
        if (theatre.getLocation() == null) {
            theatre.setLocation(original.getLocation());
        }
        if (theatre.getName() == null) {
            theatre.setName(original.getName());
        }
        return repository.updateTheatre(theatre, id);
    }

    public String deleteTheatre(int id) {
        return repository.deleteTheatre(id);
    }
}
