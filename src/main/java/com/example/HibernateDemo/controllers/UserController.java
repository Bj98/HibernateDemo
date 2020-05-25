package com.example.HibernateDemo.controllers;

import com.example.HibernateDemo.models.Post;
import com.example.HibernateDemo.models.User;
import com.example.HibernateDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping("/user/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id){
        Optional<User> user=userService.findById(id);
        if(user.isPresent()){
            return user.get().getPosts();
        }
        return null;
    }

    @GetMapping("users/location/{id}")
    public List<User> getUsersByLocationId(@PathVariable Integer id){
        return userService.getUsersByLocationId(id);
    }

    @PostMapping("/user/addNew")
    public void addUser(@RequestBody User user){
        userService.addUser(user);

    }

    @PutMapping("/user/{id}/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}/delete")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
