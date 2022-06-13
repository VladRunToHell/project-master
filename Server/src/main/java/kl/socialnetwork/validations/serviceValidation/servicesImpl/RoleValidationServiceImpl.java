package kl.socialnetwork.validations.serviceValidation.servicesImpl;

import kl.socialnetwork.domain.entities.Role;
import kl.socialnetwork.validations.serviceValidation.services.RoleValidationService;
import org.springframework.stereotype.Component;

@Component
public class RoleValidationServiceImpl implements RoleValidationService {
    @Override
    public boolean isValid(Role role) {
        return role != null;
    }
}
