package be.ersch.petclinicspringapp.repositories;

import be.ersch.petclinicspringapp.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
