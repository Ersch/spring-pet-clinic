package be.ersch.petclinicspringapp.repositories;

import be.ersch.petclinicspringapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
