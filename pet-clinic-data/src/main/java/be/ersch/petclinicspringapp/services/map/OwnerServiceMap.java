package be.ersch.petclinicspringapp.services.map;

import be.ersch.petclinicspringapp.model.Owner;
import be.ersch.petclinicspringapp.model.Pet;
import be.ersch.petclinicspringapp.repositories.OwnerRepository;
import be.ersch.petclinicspringapp.services.CrudService;
import be.ersch.petclinicspringapp.services.OwnerService;
import be.ersch.petclinicspringapp.services.PetService;
import be.ersch.petclinicspringapp.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;
    private final OwnerRepository ownerRepository;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService,OwnerRepository ownerRepository) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner obect) {
        super.delete(obect);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);    }
}
