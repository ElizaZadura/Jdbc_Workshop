package se.lexicon.DB;

import se.lexicon.dao.CityDaoImpl;
import se.lexicon.model.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseTest {

    private static final String URL = "jdbc:mysql://localhost:3306/world"; // Update with your database name
    private static final String USER = "elz"; // Replace with your MySQL username
    private static final String PASSWORD = "ps123"; // Replace with your MySQL password

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            CityDaoImpl cityDao = new CityDaoImpl(connection);

            // Test save method
            City newCity = new City(0, "Test City", "AFG", "Test District", 100000);
            City savedCity = cityDao.save(newCity);
            System.out.println("Saved City: " + savedCity);

            // Test findById method
            City foundCity = cityDao.findById(savedCity.getId());
            System.out.println("Found City: " + foundCity);

            // Test findAll method
            List<City> cities = cityDao.findAll();
            System.out.println("All Cities: " + cities);

            // Test update method
            foundCity.setPopulation(200000);
            City updatedCity = cityDao.update(foundCity);
            System.out.println("Updated City: " + updatedCity);

            // Test deleteById method
            cityDao.deleteById(updatedCity.getId());
            System.out.println("City deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
