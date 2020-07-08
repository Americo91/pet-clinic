package astoppello.springframework.petclinic.services;

import astoppello.springframework.petclinic.model.Pet;

import java.util.Set;

/**
 * Created by americo stoppello on 08/07/2020
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
