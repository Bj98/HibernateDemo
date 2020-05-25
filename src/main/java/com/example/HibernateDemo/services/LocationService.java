package com.example.HibernateDemo.services;

import com.example.HibernateDemo.models.Location;
import com.example.HibernateDemo.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return (List<Location>)locationRepository.findAll();
    }

    public Optional<Location> findById(Integer id) {
        return locationRepository.findById(id);
    }

    public void addLocation(Location location){
        locationRepository.save(location);
    }

    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    public void deleteLocation(Integer id) {
        locationRepository.deleteById(id);
    }
}
