package astoppello.springframework.petclinic.model;

/**
 * Created by americo stoppello on 07/07/2020
 */
public class PetType extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
