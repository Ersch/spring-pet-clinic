package be.ersch.petclinicspringapp.repositories;

import be.ersch.petclinicspringapp.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
