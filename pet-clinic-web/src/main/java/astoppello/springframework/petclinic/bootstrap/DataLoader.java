package astoppello.springframework.petclinic.bootstrap;

import astoppello.springframework.petclinic.model.Owner;
import astoppello.springframework.petclinic.model.Pet;
import astoppello.springframework.petclinic.model.PetType;
import astoppello.springframework.petclinic.model.Vet;
import astoppello.springframework.petclinic.services.OwnerService;
import astoppello.springframework.petclinic.services.PetTypeService;
import astoppello.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by americo stoppello on 12/07/2020
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dogType = new PetType();
        dogType.setName("Dog");
        PetType savedDog = petTypeService.save(dogType);

        PetType catType = new PetType();
        dogType.setName("Cat");
        PetType savedCat = petTypeService.save(catType);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michele");
        owner1.setLastName("Weston");
        owner1.setAddress("19 rue bricka");
        owner1.setCity("Juan les pins");
        owner1.setPhone("062113791");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDog);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Doggo");
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");
        owner2.setAddress("xxv aprile");
        owner2.setCity("castel madama");
        owner2.setPhone("0774448198");

        Pet cat = new Pet();
        cat.setBirthDate(LocalDate.now());
        cat.setName("Gatto");
        cat.setOwner(owner2);
        cat.setPetType(savedCat);
        owner2.getPets().add(cat);

        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Pippo");
        vet2.setLastName("Pluto");
        vetService.save(vet2);

        System.out.println("Loading Vets");
    }
}
