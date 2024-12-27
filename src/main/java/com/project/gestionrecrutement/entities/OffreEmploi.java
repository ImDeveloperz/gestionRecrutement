package com.project.gestionrecrutement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Table(name="offreemplois")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreEmploi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date datePublication;
    private StatusOffre status;
}
