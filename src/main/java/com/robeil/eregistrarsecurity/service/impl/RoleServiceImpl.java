package com.robeil.eregistrarsecurity.service.impl;

import com.robeil.eregistrarsecurity.model.Role;
import com.robeil.eregistrarsecurity.repository.RoleRepository;
import com.robeil.eregistrarsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(Sort.by("firstName"));
    }
}
