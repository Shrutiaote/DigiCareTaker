package com.digicaretaker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.digicaretaker.entity.Caretaker;
import com.digicaretaker.service.CaretakerService;

@RestController
@RequestMapping("/api/caretakers")
public class CaretakerController {

    private final CaretakerService caretakerService;

    public CaretakerController(CaretakerService caretakerService) {
        this.caretakerService = caretakerService;
    }

    @PostMapping
    public Caretaker createCaretaker(@RequestBody Caretaker caretaker) {
        return caretakerService.saveCaretaker(caretaker);
    }

    @GetMapping
    public List<Caretaker> getAllCaretakers() {
        return caretakerService.getAllCaretakers();
    }

    @GetMapping("/{id}")
    public Caretaker getCaretakerById(@PathVariable int id) {
        return caretakerService.getCaretakerById(id);
    }
}