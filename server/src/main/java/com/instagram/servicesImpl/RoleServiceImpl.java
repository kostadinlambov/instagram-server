package com.instagram.servicesImpl;

import com.instagram.domain.entities.UserRole;
import com.instagram.repositories.RoleRepository;
import com.instagram.services.RoleService;
import com.instagram.validations.serviceValidation.Services.RoleValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.instagram.utils.constants.ResponseMessageConstants.SERVER_ERROR_MESSAGE;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleValidationService roleValidation;


    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleValidationService roleValidation) {
        this.roleRepository = roleRepository;
        this.roleValidation = roleValidation;
    }

    @Override
    public boolean persist(UserRole role) throws Exception {
        if(!roleValidation.isValid(role)){
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        return this.roleRepository.save(role) != null;
    }

    @Override
    public UserRole getByName(String name) {
        return this.roleRepository.findByAuthority(name);
    }
}