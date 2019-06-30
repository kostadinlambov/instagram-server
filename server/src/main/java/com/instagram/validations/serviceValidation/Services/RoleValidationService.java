package com.instagram.validations.serviceValidation.Services;

import com.instagram.domain.entities.UserRole;

public interface RoleValidationService {
    boolean isValid(UserRole role);
}
