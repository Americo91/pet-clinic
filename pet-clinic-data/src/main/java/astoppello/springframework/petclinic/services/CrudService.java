package astoppello.springframework.petclinic.services;

import java.util.Set;

/**
 * Created by americo stoppello on 09/07/2020
 */
public interface CrudService<T,ID> {

    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete( T object);

    void deleteById(ID id);
}
