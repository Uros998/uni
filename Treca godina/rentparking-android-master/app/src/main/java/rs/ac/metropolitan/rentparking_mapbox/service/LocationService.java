package rs.ac.metropolitan.rentparking_mapbox.service;

import java.util.List;

import rs.ac.metropolitan.rentparking_mapbox.entity.*;


public interface LocationService {

	List<Location> findAll();

	Location save(Location location);

	Location update(Location location);

	Location findById(Integer locationId);

	void deleteById(Integer locationId);

}