package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Visit;
import astoppello.springframework.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by @author americo stoppello on 03/08/2020
 */
@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
			throw new RuntimeException("Invalid visit");
		}
		return super.save(visit);
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit visit) {
		super.delete(visit);
	}
}
