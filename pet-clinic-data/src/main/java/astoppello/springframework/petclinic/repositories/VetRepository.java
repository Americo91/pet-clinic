package astoppello.springframework.petclinic.repositories;

import astoppello.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}
