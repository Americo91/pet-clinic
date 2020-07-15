package astoppello.springframework.petclinic.model;

import java.util.Set;

/**
 * Created by americo stoppello on 07/07/2020
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
