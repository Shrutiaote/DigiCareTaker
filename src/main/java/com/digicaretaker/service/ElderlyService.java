package com.digicaretaker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digicaretaker.entity.Elderly;
import com.digicaretaker.repository.ElderlyRepository;

@Service
public class ElderlyService {

    private final ElderlyRepository elderlyRepository;

    public ElderlyService(ElderlyRepository elderlyRepository) {
        this.elderlyRepository = elderlyRepository;
    }

    public Elderly saveElderly(Elderly elderly) {
        return elderlyRepository.save(elderly);
    }

    public List<Elderly> getAllElderly() {
        return elderlyRepository.findAll();
    }

    public Elderly getElderlyById(int id) {
        return elderlyRepository.findById(id).orElse(null);
    }
}