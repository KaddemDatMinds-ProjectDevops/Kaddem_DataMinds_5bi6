package tn.esprit.spring.khaddem.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Equipe;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Niveau;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;
import tn.esprit.spring.khaddem.services.EquipeServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EquipeTest {


    @Mock
    private EquipeRepository equipeRepository;

    @Mock
    private ContratRepository contratRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    private Equipe equipe;

    @BeforeEach
    void setUp() {
        equipe = Equipe.builder()
                .idEquipe(1)
                .nomEquipe("Equipe1")
                .niveau(Niveau.JUNIOR)
                .etudiants(new ArrayList<>())
                .build();
    }

    @Test
    void testAddEquipe() {
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);
        Equipe result = equipeService.addEquipe(equipe);
        assertNotNull(result);
        assertEquals("Equipe1", result.getNomEquipe());
        verify(equipeRepository, times(1)).save(equipe);
    }

    @Test
    void testRetrieveEquipeFound() {
        when(equipeRepository.findById(1)).thenReturn(Optional.of(equipe));
        Equipe result = equipeService.retrieveEquipe(1);
        assertNotNull(result);
        assertEquals("Equipe1", result.getNomEquipe());
    }

    @Test
    void testRetrieveEquipeNotFound() {
        when(equipeRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> equipeService.retrieveEquipe(1));
    }

    @Test
    void testUpdateEquipe() {
        when(equipeRepository.findById(1)).thenReturn(Optional.of(equipe));
        equipe.setNomEquipe("UpdatedEquipe");
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipe);

        Equipe updatedEquipe = equipeService.updateEquipe(equipe);
        assertNotNull(updatedEquipe);
        assertEquals("UpdatedEquipe", updatedEquipe.getNomEquipe());
        verify(equipeRepository, times(1)).save(equipe);
    }

}