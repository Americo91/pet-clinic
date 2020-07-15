package astoppello.springframework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by americo stoppello on 07/07/2020
 */
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
