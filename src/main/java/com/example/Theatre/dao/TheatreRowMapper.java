package com.example.Theatre.dao;

import com.example.Theatre.entity.Theatre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TheatreRowMapper implements RowMapper<Theatre> {
    @Override
    public Theatre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Theatre theatre = new Theatre();
        theatre.setId(rs.getInt("TheatreID"));
        theatre.setName(rs.getString("Name"));
        theatre.setLocation(rs.getString("Location"));
        return theatre;
    }
}
