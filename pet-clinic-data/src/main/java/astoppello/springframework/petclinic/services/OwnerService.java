package astoppello.springframework.petclinic.services;

import astoppello.springframework.petclinic.model.Owner;

import java.util.Set;

/**
 * Created by americo stoppello on 08/07/2020
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
