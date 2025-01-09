package com.example.Theatre.dao;

import com.example.Theatre.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TheatreRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Theatre> getAllTheatres() {
        String sql = "SELECT * FROM Theatres";
        return jdbcTemplate.query(sql, new TheatreRowMapper());
    }

    public Theatre getTheatreById(int id) {
        String sql = "SELECT * FROM Theatres WHERE TheatreID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TheatreRowMapper());
    }

    public String addTheatre(Theatre theatre) {
        String sql = "INSERT INTO Theatres (Name, Location) VALUES (?,?);";

        int rowsAffected = jdbcTemplate.update(sql, theatre.getName(), theatre.getLocation());

        if (rowsAffected > 0) {
            return "Theatre Added Successfully";
        }

        return "Failed To Add Theatre";
    }

    public String updateTheatre(Theatre theatre, int id) {
        String sql = "UPDATE Theatres SET NAME = ?, Location = ? WHERE TheatreID = ?;";
        int rowsAffected = jdbcTemplate.update(sql, theatre.getName(), theatre.getLocation(), id);

        if (rowsAffected > 0) {
            return "Theatre Added Successfully";
        }

        return "Failed To Add Theatre";

    }

    public String deleteTheatre(int id) {
        String sql = "DELETE FROM Theatres WHERE TheatreID = ?;";

        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected > 0) {
            return "Theatre Added Successfully";
        }

        return "Failed To Add Theatre";
    }
}