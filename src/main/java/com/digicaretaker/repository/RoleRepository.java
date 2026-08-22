package com.digicaretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digicaretaker.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}