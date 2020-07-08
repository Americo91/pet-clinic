package astoppello.springframework.petclinic.services;

import astoppello.springframework.petclinic.model.Vet;

import java.util.Set;

/**
 * Created by americo stoppello on 08/07/2020
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
