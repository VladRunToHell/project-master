package kl.socialnetwork.services;

import kl.socialnetwork.domain.entities.Role;

public interface RoleService {
    boolean persist(Role role) throws Exception;

    Role getByName(String name);
}
