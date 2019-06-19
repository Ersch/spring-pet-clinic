package be.ersch.petclinicspringapp.services;

import be.ersch.petclinicspringapp.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
