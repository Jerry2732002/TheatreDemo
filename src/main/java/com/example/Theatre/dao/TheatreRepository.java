package com.example.Theatre.dao;

import com.example.Theatre.entity.Theatre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TheatreRepository {
    private final Connection connection;

    public TheatreRepository(@Value("${database.url}") String URL, @Value("${database.username}") String USERNAME, @Value("${database.password}") String PASSWORD) throws SQLException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<Theatre> getAllTheatres() {
        String query = "SELECT * FROM Theatres";
        List<Theatre> theatres = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Theatre theatre = new Theatre();
                theatre.setId(resultSet.getInt("TheatreID"));
                theatre.setName(resultSet.getString("Name"));
                theatre.setLocation(resultSet.getString("Location"));
                theatres.add(theatre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return theatres;
    }

    public Theatre getTheatreById(int id) {
        String query = "SELECT * FROM Theatres WHERE TheatreID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Theatre theatre = new Theatre();
                theatre.setId(resultSet.getInt("TheatreID"));
                theatre.setName(resultSet.getString("Name"));
                theatre.setLocation(resultSet.getString("Location"));
                return theatre;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String addTheatre(Theatre theatre) {
        String query = "INSERT INTO Theatres (Name, Location) VALUES (?,?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, theatre.getName());
            statement.setString(2, theatre.getLocation());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Theatre Added Successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Failed To Add Theatre";
    }

    public String updateTheatre(Theatre theatre, int id) {
        String query = "UPDATE Theatres SET NAME = ?, Location = ? WHERE TheatreID = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, theatre.getName());
            statement.setString(2, theatre.getLocation());
            statement.setInt(3, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Theatre Updated Successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Failed To Update Theatre";
    }

    public String deleteTheatre(int id) {
        String query = "DELETE FROM Theatres WHERE TheatreID = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Theatre Deleted Successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Failed To Delete Theatre";
    }
}