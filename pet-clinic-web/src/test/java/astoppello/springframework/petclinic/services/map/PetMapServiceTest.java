package astoppello.springframework.petclinic.services.map;

import astoppello.springframework.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetMapServiceTest {

    PetMapService petMapService;
    private static final Long ID = 1l;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        Pet pet = new Pet();
        pet.setId(ID);
        petMapService.save(pet);
    }

    @Test
    void findById() {
        Pet savedPet = petMapService.findById(ID);
        assertEquals(ID, savedPet.getId());
    }

    @Test
    void save() {
        Long petId = 2l;
        Pet pet = new Pet();
        pet.setId(petId);
        Pet savedPet = petMapService.save(pet);
        assertEquals(petId, savedPet.getId());
    }

    @Test
    void savePetNoId() {
        Pet pet = new Pet();
        Pet savedPet = petMapService.save(pet);
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void findAll() {
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(ID);
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(ID));
        assertEquals(0, petMapService.findAll().size());
    }
}