package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Vet;
import astoppello.springframework.petclinic.services.CrudService;

import java.util.Set;

/**
 * Created by americo stoppello on 09/07/2020
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long> {

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}