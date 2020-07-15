package astoppello.springframework.petclinic.model;

/**
 * Created by americo stoppello on 15/07/2020
 */
public class Speciality extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
