package com.ead.notification.controllers;

import com.ead.notification.dtos.NotificationDTO;
import com.ead.notification.models.Notification;
import com.ead.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserNotificationController {

    @Autowired
    private NotificationService service;

    @GetMapping(value = "/users/{userId}/notifications")
    public ResponseEntity<Page<NotificationDTO>> findAllUsersNotification(@PathVariable UUID userId, Pageable pageable) {
        Page<NotificationDTO> page = service.findAllUsersNotification(userId, pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping(value = "/users/{userId}/notifications/{id}")
    public ResponseEntity<NotificationDTO> updateNotificationStatus(@PathVariable UUID userId,
                                                                    @PathVariable UUID id,
                                                                    @RequestBody NotificationDTO dto){

        dto = service.updateNotificationStatus(id, userId, dto);
        return ResponseEntity.ok().body(dto);
    }
}
