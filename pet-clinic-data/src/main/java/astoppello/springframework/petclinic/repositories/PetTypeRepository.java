package astoppello.springframework.petclinic.repositories;

import astoppello.springframework.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
