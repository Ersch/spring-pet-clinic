package be.ersch.petclinicspringapp.services.springdatajpa;

import be.ersch.petclinicspringapp.model.Vet;
import be.ersch.petclinicspringapp.repositories.VetRepository;
import be.ersch.petclinicspringapp.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaServices implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaServices(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet obect) {
        vetRepository.delete(obect);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
