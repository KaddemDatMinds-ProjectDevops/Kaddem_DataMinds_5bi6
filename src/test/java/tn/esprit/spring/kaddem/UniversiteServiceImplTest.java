package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UniversiteServiceImplTest {

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private DepartementRepository departementRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUniversite() {
        Universite universiteToAdd = new Universite();
        universiteToAdd.setNomUniv("Sample Universite");

        when(universiteRepository.save(universiteToAdd)).thenReturn(universiteToAdd);

        Universite addedUniversite = universiteService.addUniversite(universiteToAdd);

        Assertions.assertEquals(universiteToAdd, addedUniversite);
        verify(universiteRepository, times(1)).save(universiteToAdd);
    }

    @Test
    void testUpdateUniversite() {
        Universite universiteToUpdate = new Universite();
        universiteToUpdate.setIdUniv(1);
        universiteToUpdate.setNomUniv("Updated Universite");

        when(universiteRepository.save(universiteToUpdate)).thenReturn(universiteToUpdate);

        Universite updatedUniversite = universiteService.updateUniversite(universiteToUpdate);

        Assertions.assertEquals(universiteToUpdate, updatedUniversite);
        verify(universiteRepository, times(1)).save(universiteToUpdate);
    }

    @Test
    void testRetrieveUniversite() {
        Universite expectedUniversite = new Universite();
        expectedUniversite.setIdUniv(1);

        when(universiteRepository.findById(1)).thenReturn(Optional.of(expectedUniversite));

        Universite retrievedUniversite = universiteService.retrieveUniversite(1);

        Assertions.assertEquals(expectedUniversite, retrievedUniversite);
        verify(universiteRepository, times(1)).findById(1);
    }

    @Test
    void testRetrieveAllUniversites() {
        List<Universite> universites = new ArrayList<>();
        universites.add(new Universite());
        universites.add(new Universite());

        when(universiteRepository.findAll()).thenReturn(universites);

        List<Universite> retrievedUniversites = universiteService.retrieveAllUniversites();

        Assertions.assertEquals(2, retrievedUniversites.size());
        verify(universiteRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUniversite() {
        Universite universiteToDelete = new Universite();
        universiteToDelete.setIdUniv(1);

        when(universiteRepository.findById(1)).thenReturn(Optional.of(universiteToDelete));
        doNothing().when(universiteRepository).delete(universiteToDelete);

        universiteService.deleteUniversite(1);

        verify(universiteRepository, times(1)).delete(universiteToDelete);
    }

    @Test
    void testAssignUniversiteToDepartement() {
        Universite universite = new Universite();
        universite.setIdUniv(1);
        universite.setDepartements(new HashSet<>());

        Departement departement = new Departement();
        departement.setIdDepart(1);

        when(universiteRepository.findById(1)).thenReturn(Optional.of(universite));
        when(departementRepository.findById(1)).thenReturn(Optional.of(departement));
        when(universiteRepository.save(universite)).thenReturn(universite);

        universiteService.assignUniversiteToDepartement(1, 1);

        Assertions.assertTrue(universite.getDepartements().contains(departement));
        verify(universiteRepository, times(1)).save(universite);
    }

    
}
