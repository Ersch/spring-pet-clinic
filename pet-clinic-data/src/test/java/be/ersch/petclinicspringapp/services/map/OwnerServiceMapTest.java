package be.ersch.petclinicspringapp.services.map;

import be.ersch.petclinicspringapp.model.Owner;
import be.ersch.petclinicspringapp.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap(), new OwnerRepository() {
            @Override
            public Owner findByLastName(String lastName) {
                return null;
            }

            @Override
            public List<Owner> findAllByLastNameLike(String lastName) {
                return null;
            }

            @Override
            public <S extends Owner> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Owner> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Owner> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Owner> findAll() {
                return null;
            }

            @Override
            public Iterable<Owner> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Owner entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Owner> entities) {

            }

            @Override
            public void deleteAll() {

            }
        });
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        ownerServiceMap.deleteById(owner.getId());
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = new Owner();
        owner2.setId(id);
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, owner2.getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = new Owner();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
    }

    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(ownerId,smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerServiceMap.findByLastName("foo");
        assertNull(smith);
    }
}