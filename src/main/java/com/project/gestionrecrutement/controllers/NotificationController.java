package com.project.gestionrecrutement.controllers;

import com.project.gestionrecrutement.entities.Notification;
import com.project.gestionrecrutement.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @GetMapping
    public String getAllNotifications(Model model) {
        List<Notification> notifications = notificationService.getAllNotifications();
        model.addAttribute("listNotifications", notifications);
        return "notifications";
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "redirect:/ListesDesNotifications";
    }

}
