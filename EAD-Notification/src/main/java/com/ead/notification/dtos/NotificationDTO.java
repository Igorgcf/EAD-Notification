package com.ead.notification.dtos;

import com.ead.notification.enums.NotificationStatus;
import com.ead.notification.models.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NotificationDTO {

    private UUID id;
    private UUID userId;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private NotificationStatus notificationStatus;

    public NotificationDTO() {
    }

    public NotificationDTO(Notification entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.message = entity.getMessage();
        this.creationDate = entity.getCreationDate();
        this.notificationStatus = entity.getNotificationStatus();
    }



}
