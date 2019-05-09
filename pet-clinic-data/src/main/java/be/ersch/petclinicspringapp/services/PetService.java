package be.ersch.petclinicspringapp.services;

import be.ersch.petclinicspringapp.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
