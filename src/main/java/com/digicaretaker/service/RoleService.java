package com.digicaretaker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digicaretaker.entity.Role;
import com.digicaretaker.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}