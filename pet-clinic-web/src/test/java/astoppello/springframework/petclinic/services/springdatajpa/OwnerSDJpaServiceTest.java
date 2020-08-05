package astoppello.springframework.petclinic.services.springdatajpa;

import astoppello.springframework.petclinic.model.Owner;
import astoppello.springframework.petclinic.repositories.OwnerRepository;
import astoppello.springframework.petclinic.repositories.PetRepository;
import astoppello.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    String SMITH = "Smith";
    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setLastName(SMITH);
        owner.setId(1l);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = service.findByLastName(SMITH);
        assertEquals(SMITH, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner o = service.findById(1l);
        assertNotNull(o);
        assertEquals(1l, o.getId());
    }

    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner o = service.findById(1l);
        assertNull(o);
    }

    @Test
    void save() {
        Owner o = new Owner();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = service.save(o);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnedOwners = service.findAll();
        assertEquals(1, returnedOwners.size());
        verify(ownerRepository).findAll();
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(ownerRepository).deleteById(anyLong());
    }
}