package com.example.projet_integration.service;

import com.example.projet_integration.dto.RapportDTO;
import com.example.projet_integration.dto.RapportResponseDto;
import com.example.projet_integration.entity.Rapport;
import com.example.projet_integration.entity.User;
import com.example.projet_integration.repository.RapportRepository;
import com.example.projet_integration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    @Autowired
    private UserRepository userRepository;

    public String insertRapport(RapportDTO rapportDTO,int id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            return "Utilisateur non trouvé";
        }

        User user = userOptional.get();


        Rapport rapport = new Rapport();
        rapport.setExtraHours(rapportDTO.extraHours);
        rapport.setWorkDay(rapportDTO.workDay);
        rapport.setBreakDay(rapportDTO.breakDay);
        rapport.setWorkHour(rapportDTO.breakDay);
        rapport.setUser(user);

        rapportRepository.save(rapport);

        return "Rapport ajouté avec succès";
    }
    public List<RapportResponseDto> getRapportsByUserId(int userId) {
        List<Rapport> rapports = rapportRepository.findByUserId(userId);
        List<RapportResponseDto> response = new ArrayList<>();

        rapports.forEach(rapport -> {
            System.out.println(rapport.getBreakDay());
            response.add(
                new RapportResponseDto(rapport.getBreakDay(), rapport.getExtraHours(), rapport.getWorkDay(), rapport.getWorkHour(), rapport.getUser().getId(), rapport.getUser().getName())
            );
        });

        return response;

    }
}
