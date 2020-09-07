package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Owner;
import astoppello.springframework.petclinic.model.Pet;
import astoppello.springframework.petclinic.services.OwnerService;
import astoppello.springframework.petclinic.services.PetService;
import astoppello.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by americo stoppello on 09/07/2020
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (!CollectionUtils.isEmpty(owner.getPets())) {
                owner.getPets()
                     .forEach(pet -> {
                         //Take care of PetType id
                         if (pet.getPetType() != null) {
                             if (pet.getPetType()
                                    .getId() == null) {
                                 pet.setPetType(petTypeService.save(pet.getPetType()));
                             }
                         } else {
                             throw new RuntimeException("Pet Type is required");
                         }
                         //Take care of Pet id
                         if (pet.getId() == null) {
                             Pet savedPet = petService.save(pet);
                             pet.setId(savedPet.getId());
                         }
                     });
            }
            return super.save(owner);
        } else {
            return null;
        }
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

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                   .stream()
                   .filter(owner -> lastName.equalsIgnoreCase(owner.getLastName()))
                   .findFirst()
                   .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return this.findAll()
                   .stream()
                   .filter(owner -> lastName.equalsIgnoreCase(owner.getLastName()))
                   .collect(Collectors.toList());
    }
}
