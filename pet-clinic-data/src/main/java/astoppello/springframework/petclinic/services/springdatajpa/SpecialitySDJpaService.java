package astoppello.springframework.petclinic.services.springdatajpa;

import astoppello.springframework.petclinic.model.Speciality;
import astoppello.springframework.petclinic.repositories.SpecialityRepository;
import astoppello.springframework.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality speciality) {
		return specialityRepository.save(speciality);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().iterator().forEachRemaining(specialities::add);
		return specialities;
	}

	@Override
	public void delete(Speciality speciality) {
		specialityRepository.delete(speciality);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}
}
