package astoppello.springframework.petclinic.repositories;

import astoppello.springframework.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
