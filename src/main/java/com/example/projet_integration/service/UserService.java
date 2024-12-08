package com.example.projet_integration.service;

import com.example.projet_integration.dto.UserLoginDTO;
import com.example.projet_integration.dto.UserProfileDTO;
import com.example.projet_integration.entity.Pointage;
import com.example.projet_integration.entity.User;
import com.example.projet_integration.repository.PointageRepository;
import com.example.projet_integration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PointageRepository pointageRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserWithPointages(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

public int login(UserLoginDTO loginDTO) {
    Optional<User> user = userRepository.findByEmail(loginDTO.email);
    if (user.isPresent() && user.get().getPassword().equals(loginDTO.password)) {
        User loggedInUser = user.get();

        // Create a Pointage object
        Pointage pointage = new Pointage();
        pointage.setStartTime(LocalDateTime.now()); // Current login time
        pointage.setLatitude(0.0);  // Fill with actual latitude if necessary
        pointage.setLongitude(0.0); // Fill with actual longitude if necessary
        pointage.setUser(loggedInUser); // Associate this pointage with the logged-in user

        // Save the pointage in the database
        pointageRepository.save(pointage);

        return loggedInUser.getId();
    }
    return -1;
}
    public String updateProfile(int id, UserProfileDTO profileDTO) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User u = user.get();
            u.setName(profileDTO.name);
            u.setLastname(profileDTO.lastname);
            u.setTel(profileDTO.phone);
            u.setMatricule((int) profileDTO.matricule); // Cast to int
            System.out.println(profileDTO);
            userRepository.save(u);

            return "Profile updated successfully.";
        }

        return "User not found.";
    }

    public String logout(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User loggedOutUser = user.get();
            Optional<Pointage> pointage = pointageRepository.findTopByUserOrderByStartTimeDesc(loggedOutUser);
            if (pointage.isPresent()) {
                Pointage p = pointage.get();
                p.setCheckOutTime(LocalDateTime.now()); // Set the checkOutTime to the current time
                pointageRepository.save(p);
                return "Logged out successfully and checkOutTime updated";
            }
            return "No pointage found for the user";
        }
        return "User not found";
    }

    public List<Pointage> getPointagesByUserId(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get().getPointages();
        }
        return null;
    }
}