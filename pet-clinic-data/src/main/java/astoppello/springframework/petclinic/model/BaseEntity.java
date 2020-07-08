package astoppello.springframework.petclinic.model;

import java.io.Serializable;

/**
 * Created by americo stoppello on 08/07/2020
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
