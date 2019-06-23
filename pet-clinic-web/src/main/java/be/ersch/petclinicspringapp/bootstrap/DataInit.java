package be.ersch.petclinicspringapp.bootstrap;

import be.ersch.petclinicspringapp.model.*;
import be.ersch.petclinicspringapp.services.OwnerService;
import be.ersch.petclinicspringapp.services.PetTypeService;
import be.ersch.petclinicspringapp.services.SpecialityService;
import be.ersch.petclinicspringapp.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Slf4j
@Component
public class DataInit implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInit(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            log.info("***************");
            log.info("Start data init");
            loadData();
            log.info("Data loaded");
            log.info("***************");
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        log.info("Loaded PetTypes...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality savedSurgery = specialityService.save(surgery);

        log.info("Loaded Specialities...");


        Owner owner1 = new Owner();
        owner1.setFirstName("Toto");
        owner1.setLastName("Owner ");
        owner1.setAddress("123 Long Street");
        owner1.setCity("San Francisco");
        owner1.setTelephone("+32 111 111 111");
        Pet totosPet = new Pet();
        totosPet.setOwner(owner1);
        totosPet.setBirthDate(LocalDate.now());
        totosPet.setName("Pluto");
        totosPet.setPetType(dog);
        owner1.getPets().add(totosPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Tata");
        owner2.setLastName("Owner ");
        owner2.setAddress("123 Long Street");
        owner2.setCity("San Francisco");
        owner2.setTelephone("+32 222 111 111");

        Pet tatasPet = new Pet();
        tatasPet.setOwner(owner1);
        tatasPet.setBirthDate(LocalDate.now());
        tatasPet.setName("Miaous");
        tatasPet.setPetType(cat);
        owner2.getPets().add(tatasPet);

        ownerService.save(owner2);

        log.info("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Riri");
        vet1.setLastName("Vet");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Loulou");
        vet2.setLastName("Vet");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        log.info("Loaded Vets...");
    }
}
