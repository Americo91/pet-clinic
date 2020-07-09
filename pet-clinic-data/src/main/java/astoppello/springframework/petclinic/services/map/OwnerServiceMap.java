package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Owner;
import astoppello.springframework.petclinic.services.CrudService;

import java.util.Set;

/**
 * Created by americo stoppello on 09/07/2020
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }
}
