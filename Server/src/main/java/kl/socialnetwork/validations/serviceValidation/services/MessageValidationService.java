package kl.socialnetwork.validations.serviceValidation.services;

import kl.socialnetwork.domain.models.bindingModels.message.*;

public interface MessageValidationService {
    boolean isValid(MessageCreateBindingModel messageCreateBindingModel);
}
