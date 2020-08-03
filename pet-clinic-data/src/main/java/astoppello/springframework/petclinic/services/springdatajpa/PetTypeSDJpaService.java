package astoppello.springframework.petclinic.services.springdatajpa;

import astoppello.springframework.petclinic.model.PetType;
import astoppello.springframework.petclinic.repositories.PetTypeRepository;
import astoppello.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType petType) {
		return petTypeRepository.save(petType);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes= new HashSet<>();
		petTypeRepository.findAll().iterator().forEachRemaining(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType petType) {
		petTypeRepository.delete(petType);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}
}
