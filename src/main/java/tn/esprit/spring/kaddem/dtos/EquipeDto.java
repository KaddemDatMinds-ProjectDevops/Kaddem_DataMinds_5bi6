package tn.esprit.spring.kaddem.dtos;

import lombok.Value;
import tn.esprit.spring.kaddem.entities.Niveau;

import java.io.Serializable;

/**
 * DTO for {@link tn.esprit.spring.kaddem.entities.Equipe}
 */
@Value
public class EquipeDto implements Serializable {
    String nomEquipe;
    Niveau niveau;
}