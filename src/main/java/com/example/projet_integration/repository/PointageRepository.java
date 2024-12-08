package com.example.projet_integration.repository;

import com.example.projet_integration.entity.Pointage;
import com.example.projet_integration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointageRepository extends JpaRepository<Pointage,Integer> {
    Optional<Pointage> findTopByUserOrderByStartTimeDesc(User user);

}
