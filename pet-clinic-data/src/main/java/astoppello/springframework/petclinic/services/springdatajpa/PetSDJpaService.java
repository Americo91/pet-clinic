package astoppello.springframework.petclinic.services.springdatajpa;

import astoppello.springframework.petclinic.model.Pet;
import astoppello.springframework.petclinic.repositories.PetRepository;
import astoppello.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

	private final PetRepository petRepository;

	public PetSDJpaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().iterator().forEachRemaining(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet oet) {
		petRepository.delete(oet);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
}
