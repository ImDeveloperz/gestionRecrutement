package com.project.gestionrecrutement.repositories;

import com.project.gestionrecrutement.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}