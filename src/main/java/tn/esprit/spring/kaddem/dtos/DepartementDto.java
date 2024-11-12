package tn.esprit.spring.kaddem.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link tn.esprit.spring.kaddem.entities.Departement}
 */
@Value
public class DepartementDto implements Serializable {
    String nomDepart;
}