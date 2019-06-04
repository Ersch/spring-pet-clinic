package be.ersch.petclinicspringapp.repositories;

import be.ersch.petclinicspringapp.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
