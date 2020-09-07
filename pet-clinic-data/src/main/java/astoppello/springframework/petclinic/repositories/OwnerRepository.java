package astoppello.springframework.petclinic.repositories;

import astoppello.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastname);

	List<Owner> findAllByLastNameLike(String lastName);
}
