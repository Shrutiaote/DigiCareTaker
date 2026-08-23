package com.digicaretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digicaretaker.entity.Caretaker;

public interface CaretakerRepository extends JpaRepository<Caretaker, Integer> {

}