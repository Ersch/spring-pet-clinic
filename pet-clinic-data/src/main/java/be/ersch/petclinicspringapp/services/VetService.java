package be.ersch.petclinicspringapp.services;

import be.ersch.petclinicspringapp.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findBtId(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
