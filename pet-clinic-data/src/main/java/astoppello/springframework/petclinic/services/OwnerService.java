package astoppello.springframework.petclinic.services;

import astoppello.springframework.petclinic.model.Owner;

import java.util.List;

/**
 * Created by americo stoppello on 08/07/2020
 */
public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
