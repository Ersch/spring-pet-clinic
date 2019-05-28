package be.ersch.petclinicspringapp.bootstrap;

import be.ersch.petclinicspringapp.model.Owner;
import be.ersch.petclinicspringapp.model.PetType;
import be.ersch.petclinicspringapp.model.Vet;
import be.ersch.petclinicspringapp.services.OwnerService;
import be.ersch.petclinicspringapp.services.PetTypeService;
import be.ersch.petclinicspringapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");


        Owner owner1 = new Owner();
        owner1.setFirstName("Toto");
        owner1.setLastName("Owner ");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tata");
        owner2.setLastName("Owner ");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Riri");
        vet1.setLastName("Vet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Loulou");
        vet2.setLastName("Vet");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
