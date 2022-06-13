package kl.socialnetwork.utils.entitiesSeed;

import kl.socialnetwork.domain.entities.Role;
import kl.socialnetwork.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EntitiesSeedExecutor {
    private final RoleRepository roleRepository;

    @Autowired
    public EntitiesSeedExecutor(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void insertEntities() {

        // Role initialisation
        if(roleRepository.count() == 0L ){
            Role role1 = new Role();
            Role role2 = new Role();
            Role role3 = new Role();
            role1.setAuthority("ADMIN");
            role2.setAuthority("USER");
            role3.setAuthority("ROOT");
            this.roleRepository.save(role1);
            this.roleRepository.save(role2);
            this.roleRepository.save(role3);
        }
    }
}
