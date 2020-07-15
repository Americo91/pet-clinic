package astoppello.springframework.petclinic.bootstrap;

import astoppello.springframework.petclinic.model.Owner;
import astoppello.springframework.petclinic.model.PetType;
import astoppello.springframework.petclinic.model.Vet;
import astoppello.springframework.petclinic.services.OwnerService;
import astoppello.springframework.petclinic.services.PetTypeService;
import astoppello.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michele");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");

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
