package be.ersch.petclinicspringapp.services.map;

import be.ersch.petclinicspringapp.model.Pet;
import be.ersch.petclinicspringapp.services.CrudService;
import be.ersch.petclinicspringapp.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet obect) {
        super.delete(obect);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
