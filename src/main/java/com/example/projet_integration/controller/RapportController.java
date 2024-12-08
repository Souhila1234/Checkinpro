package com.example.projet_integration.controller;



import com.example.projet_integration.dto.RapportDTO;
import com.example.projet_integration.dto.RapportResponseDto;
import com.example.projet_integration.entity.Rapport;
import com.example.projet_integration.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapports")
public class RapportController {

    @Autowired
    private RapportService rapportService;


    @PostMapping("/add/{id}")
    public String addRapport(@RequestBody RapportDTO rapportDTO, @PathVariable int id) {
        return rapportService.insertRapport(rapportDTO,id);
    }
    @GetMapping("/user/{userId}")
    public List<RapportResponseDto> getRapportsByUserId(@PathVariable int userId) {
        return rapportService.getRapportsByUserId(userId);
    }
}

