package tn.esprit.spring.kaddem.dtos;

import lombok.Value;
import tn.esprit.spring.kaddem.entities.Option;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link tn.esprit.spring.kaddem.entities.Etudiant}
 */
@Value
public class EtudiantDto implements Serializable {
    String nomE;
    String prenomE;
    Option op;
    Set<ContratDto> contrats;
    DepartementDto departement;
    List<EquipeDto> equipes;
}