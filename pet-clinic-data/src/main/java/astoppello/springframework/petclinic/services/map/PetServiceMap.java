package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Pet;
import astoppello.springframework.petclinic.services.CrudService;

import java.util.Set;

/**
 * Created by americo stoppello on 09/07/2020
 */
public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }
}
