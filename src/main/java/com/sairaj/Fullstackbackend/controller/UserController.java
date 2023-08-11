package com.sairaj.Fullstackbackend.controller;

import com.sairaj.Fullstackbackend.excaption.UserNotFoundException;
import com.sairaj.Fullstackbackend.model.User;
import com.sairaj.Fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
        User newUser(@RequestBody User newUser)
        {
            return userRepository.save(newUser);
        }

    @GetMapping("/users")
    List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id)
    {
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id)
    {
        return  userRepository.findById(id).map(user -> {user.setUserName(newUser.getUserName());
                                                        user.setName(newUser.getName());
                                                        user.setEmail(newUser.getEmail());
                                                        return  userRepository.save(user);
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id)
    {
        if(!userRepository.existsById(id))
        {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
        return "User has been deleted sucessfully with the id: " + id;
    }
}
