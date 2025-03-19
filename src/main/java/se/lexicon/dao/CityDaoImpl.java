package se.lexicon.dao;

import se.lexicon.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the implementation of CityDao for interacting with the 'city' table in the database.
 */
public class CityDaoImpl implements CityDao {

    private Connection connection;

    public CityDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public City findById(int id) {
        String sql = "SELECT * FROM city WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new City(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("countryCode"),
                        rs.getString("district"),
                        rs.getLong("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return null;
    }

    @Override
    public City findByCode(String code) {
        String sql = "SELECT * FROM city WHERE countryCode = ?";
        return getCity(code, sql);
    }

    private City getCity(String code, String sql) {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new City(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("countryCode"),
                        rs.getString("district"),
                        rs.getLong("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return null;
    }

    @Override
    public City findByName(String name) {
        String sql = "SELECT * FROM city WHERE name = ?";
        return getCity(name, sql);
    }

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                cities.add(new City(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("countryCode"),
                        rs.getString("district"),
                        rs.getLong("population")));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return cities;
    }

    @Override
    public City save(City city) {
        String sql = "INSERT INTO city (name, countryCode, district, population) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, city.getName());
            stmt.setString(2, city.getCountryCode());
            stmt.setString(3, city.getDistrict());
            stmt.setLong(4, city.getPopulation());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1)); // Set the generated ID
                }
                return city;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return null;
    }

    @Override
    public City update(City city) {
        String sql = "UPDATE city SET name = ?, countryCode = ?, district = ?, population = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, city.getName());
            stmt.setString(2, city.getCountryCode());
            stmt.setString(3, city.getDistrict());
            stmt.setLong(4, city.getPopulation());
            stmt.setInt(5, city.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                return city;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM city WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
        }
    }
}
