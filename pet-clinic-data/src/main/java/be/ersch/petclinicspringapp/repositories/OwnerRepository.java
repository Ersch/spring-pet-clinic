package be.ersch.petclinicspringapp.repositories;

import be.ersch.petclinicspringapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
