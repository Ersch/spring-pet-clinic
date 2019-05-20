package be.ersch.petclinicspringapp.services.map;

import be.ersch.petclinicspringapp.model.Owner;
import be.ersch.petclinicspringapp.model.Vet;
import be.ersch.petclinicspringapp.services.CrudService;
import be.ersch.petclinicspringapp.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet obect) {
        super.delete(obect);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
