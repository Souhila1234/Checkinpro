package com.example.projet_integration.repository;

import com.example.projet_integration.entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RapportRepository extends JpaRepository<Rapport,Integer> {
    List<Rapport> findByUserId(int userId);
}
