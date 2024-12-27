package com.project.gestionrecrutement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Condidatures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condidature {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusCondidature statusCondidature;
}
