package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    final long ID = 1l;
    final String smith = "Smith";
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(ID);
        owner.setLastName(smith);
        ownerMapService.save(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ID);
        assertEquals(ID, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2l;
        Owner owner = new Owner();
        owner.setId(id);

        Owner savedOwner = ownerMapService.save(owner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = new Owner();
        Owner savedOwner = ownerMapService.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> set = ownerMapService.findAll();
        assertEquals(1, set.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(smith);
        assertNotNull(owner);
        assertEquals(smith, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }
}