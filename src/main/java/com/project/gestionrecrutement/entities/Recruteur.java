package com.project.gestionrecrutement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("recruteur")
public class Recruteur extends Utilisateur {

    @OneToMany(mappedBy = "recruteur")
    private List<OffreEmploi> offreEmplois;
}
