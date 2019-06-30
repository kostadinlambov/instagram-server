package com.instagram.validations.serviceValidation.servicesImpl;

import com.instagram.domain.entities.UserRole;
import com.instagram.validations.serviceValidation.Services.RoleValidationService;
import org.springframework.stereotype.Component;

@Component
public class RoleValidationServiceImpl implements RoleValidationService {
    @Override
    public boolean isValid(UserRole role) {
        return role != null;
    }
}
