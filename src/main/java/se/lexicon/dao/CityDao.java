package se.lexicon.dao;

import se.lexicon.model.City;

import java.util.List;

public interface CityDao {
    City findById(int id);

    City findByCode(String code);

    City findByName(String name);

    List<City> findAll();

    City save(City city);

    City update(City city);

    void deleteById(int id);
}
