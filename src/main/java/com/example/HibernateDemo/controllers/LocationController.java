package com.example.HibernateDemo.controllers;

import com.example.HibernateDemo.models.Location;
import com.example.HibernateDemo.models.User;
import com.example.HibernateDemo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        return locationService.findAll();
    }

    @GetMapping("/location/{id}")
    public Optional<Location> getLocationById(@PathVariable Integer id){
        return locationService.findById(id);
    }

    @GetMapping("/location/{id}/users")
    public List<User> getUsersByLocationId(@PathVariable Integer id){
        Optional<Location> location=locationService.findById(id);
        if(location.isPresent()){
            return location.get().getUsers();
        }
        return null;
    }

    @PostMapping("/location/addNew")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @PutMapping("/location/{id}/update")
    public void updateLocation(@RequestBody Location location){
        locationService.updateLocation(location);
    }

    @DeleteMapping("/location/{id}/delete")
    public void deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
    }
}
