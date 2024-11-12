package tn.esprit.spring.kaddem.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link tn.esprit.spring.kaddem.entities.Universite}
 */
@Value
public class UniversiteDto implements Serializable {
    String nomUniv;
    Set<DepartementDto> departements;
}