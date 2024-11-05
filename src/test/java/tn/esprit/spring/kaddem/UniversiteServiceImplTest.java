package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UniversiteServiceImplTest {

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void addUniversite() {
        Universite universiteToAdd = new Universite();
        universiteToAdd.setNomUniv("Sample Universite");
        when(universiteRepository.save((universiteToAdd))).thenReturn(universiteToAdd);
        Universite addedUniversite = universiteService.addUniversite(universiteToAdd);
        Assertions.assertEquals(universiteToAdd, addedUniversite);
    }
    @Test
    void updateUniversite() {
        Universite universiteToUpdate = new Universite();
        universiteToUpdate.setIdUniv(1);
        universiteToUpdate.setNomUniv("Updated Universite");
        when(universiteRepository.save((universiteToUpdate))).thenReturn(universiteToUpdate);
        Universite updatedUniversite = universiteService.updateUniversite(universiteToUpdate);
        Assertions.assertEquals(universiteToUpdate, updatedUniversite);
    }
    @Test
    void retrieveUniversite() {
        Universite expectedUniversite = new Universite();
        expectedUniversite.setIdUniv(1);
        when(universiteRepository.findById(1)).thenReturn(Optional.of(expectedUniversite));
        Universite retrievedUniversite = universiteService.retrieveUniversite(1);
        Assertions.assertEquals(expectedUniversite, retrievedUniversite);
    }

}
