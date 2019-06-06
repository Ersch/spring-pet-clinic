package be.ersch.petclinicspringapp.services.map;

import be.ersch.petclinicspringapp.model.Pet;
import be.ersch.petclinicspringapp.model.Visit;
import be.ersch.petclinicspringapp.services.PetTypeService;
import be.ersch.petclinicspringapp.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final VisitMapService visitMapService;
    private final PetTypeService petTypeService;

    public VisitMapService(VisitMapService visitMapService, PetTypeService petTypeService) {
        this.visitMapService = visitMapService;
        this.petTypeService = petTypeService;
    }


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit obect) {
        super.delete(obect);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null ||
                object.getPet().getOwner() == null ||
                object.getPet().getId() == null ||
                object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
