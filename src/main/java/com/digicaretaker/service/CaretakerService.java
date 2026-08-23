package com.digicaretaker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digicaretaker.entity.Caretaker;
import com.digicaretaker.repository.CaretakerRepository;

@Service
public class CaretakerService {

    private final CaretakerRepository caretakerRepository;

    public CaretakerService(CaretakerRepository caretakerRepository) {
        this.caretakerRepository = caretakerRepository;
    }

    public Caretaker saveCaretaker(Caretaker caretaker) {
        return caretakerRepository.save(caretaker);
    }

    public List<Caretaker> getAllCaretakers() {
        return caretakerRepository.findAll();
    }

    public Caretaker getCaretakerById(int id) {
        return caretakerRepository.findById(id).orElse(null);
    }
}