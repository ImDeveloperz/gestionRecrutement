package com.project.gestionrecrutement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("candidat")
public class Candidat extends Utilisateur {
    private String cv;

    @OneToMany(mappedBy = "candidat")
    private List<Candidature> candidatures;
}
