package com.project.gestionrecrutement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="candidatures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidature {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusCondidature statusCondidature;

    @ManyToOne
    @JoinColumn(name = "idCandidat")
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "idOffreEmploi")
    private OffreEmploi offreEmploi;

    @OneToOne(mappedBy = "candidature")
    private Notification notification;
}
