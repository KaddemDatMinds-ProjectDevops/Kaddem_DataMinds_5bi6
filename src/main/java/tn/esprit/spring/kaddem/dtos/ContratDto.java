package tn.esprit.spring.kaddem.dtos;

import lombok.Value;
import tn.esprit.spring.kaddem.entities.Specialite;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link tn.esprit.spring.kaddem.entities.Contrat}
 */
@Value
public class ContratDto implements Serializable {
    Date dateDebutContrat;
    Date dateFinContrat;
    Specialite specialite;
    Boolean archive;
    Integer montantContrat;
    EtudiantDto etudiant;
}