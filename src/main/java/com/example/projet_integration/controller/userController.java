package com.example.projet_integration.controller;

import com.example.projet_integration.dto.UserLoginDTO;
import com.example.projet_integration.dto.LoginResponseDto;
import com.example.projet_integration.dto.UserProfileDTO;
import com.example.projet_integration.entity.Pointage;
import com.example.projet_integration.entity.User;
import com.example.projet_integration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class  userController {
    @Autowired
    private UserService userService;

 @PostMapping("/login")
public ResponseEntity<Integer> login(@RequestBody UserLoginDTO loginRequest) {
    int userId = userService.login(loginRequest);
    if (userId == -1) {
        return ResponseEntity.status(401).body(null);
    }
    return ResponseEntity.ok(userId);
}

    @PutMapping("/modifier/{id}")
    public String modifier(@PathVariable("id") int id, @RequestBody UserProfileDTO userProfileDTO) {
        return userService.updateProfile(id, userProfileDTO);
    }

    @PostMapping("/logout/{id}")
    public String logout(@PathVariable("id") int id) {
        return userService.logout(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}/pointages")
    public List<Pointage> getPointagesByUserId(@PathVariable("id") int id) {
        return userService.getPointagesByUserId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(user);
    }
}