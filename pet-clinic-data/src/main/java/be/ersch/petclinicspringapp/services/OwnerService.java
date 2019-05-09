package be.ersch.petclinicspringapp.services;

import be.ersch.petclinicspringapp.model.Owner;
import java.util.Set;

public interface OwnerService {

    Owner findBtId(Long id);

    Owner save(Owner owner);

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

}
