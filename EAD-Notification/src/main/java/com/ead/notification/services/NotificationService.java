package com.ead.notification.services;

import com.ead.notification.dtos.NotificationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NotificationService {

    void save(NotificationDTO dto);

    Page<NotificationDTO> findAllUsersNotification(UUID userId, Pageable pageable);

    NotificationDTO updateNotificationStatus(UUID notificationId, UUID userId, NotificationDTO dto);

}
