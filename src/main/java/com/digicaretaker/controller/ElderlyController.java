package com.digicaretaker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.digicaretaker.entity.Elderly;
import com.digicaretaker.service.ElderlyService;

@RestController
@RequestMapping("/api/elderly")
public class ElderlyController {

    private final ElderlyService elderlyService;

    public ElderlyController(ElderlyService elderlyService) {
        this.elderlyService = elderlyService;
    }

    @PostMapping
    public Elderly createElderly(@RequestBody Elderly elderly) {
        return elderlyService.saveElderly(elderly);
    }

    @GetMapping
    public List<Elderly> getAllElderly() {
        return elderlyService.getAllElderly();
    }

    @GetMapping("/{id}")
    public Elderly getElderlyById(@PathVariable int id) {
        return elderlyService.getElderlyById(id);
    }
}