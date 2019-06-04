package be.ersch.petclinicspringapp.repositories;

import be.ersch.petclinicspringapp.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
