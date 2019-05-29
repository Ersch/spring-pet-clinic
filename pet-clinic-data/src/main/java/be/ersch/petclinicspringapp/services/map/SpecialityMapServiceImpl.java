package be.ersch.petclinicspringapp.services.map;

import be.ersch.petclinicspringapp.model.Speciality;
import be.ersch.petclinicspringapp.services.SpecialityService;

import java.util.Set;

public class SpecialityMapServiceImpl extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality obect) {
        super.delete(obect);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
