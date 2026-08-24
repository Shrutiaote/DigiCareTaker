package com.digicaretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digicaretaker.entity.Elderly;

public interface ElderlyRepository extends JpaRepository<Elderly, Integer> {

}