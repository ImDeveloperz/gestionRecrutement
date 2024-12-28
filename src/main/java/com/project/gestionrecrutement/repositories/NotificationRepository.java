package com.project.gestionrecrutement.repositories;

import com.project.gestionrecrutement.entities.Notification;
import com.project.gestionrecrutement.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}