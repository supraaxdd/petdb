package com.supra.petdb.services;

import com.supra.petdb.repositories.PetRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class PetService implements IPetService {
    private PetRepository petRepository;

    @Override
    public int getTotalPetCount() {
        return petRepository.getTotalCount();
    }
}
