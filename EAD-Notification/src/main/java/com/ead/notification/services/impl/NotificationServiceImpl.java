package com.ead.notification.services.impl;

import com.ead.notification.dtos.NotificationDTO;
import com.ead.notification.enums.NotificationStatus;
import com.ead.notification.models.Notification;
import com.ead.notification.repositories.NotificationRepository;
import com.ead.notification.services.NotificationService;
import com.ead.notification.services.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void save(NotificationDTO dto) {

        log.debug("save dto received: {}", dto);
        Notification notification = new Notification();
        copyDtoToEntity(notification, dto);
        notificationRepository.save(notification);
        log.debug("save entity saved: {}", notification);
        log.info("Notification saved successfully");
    }

    @Override
    public Page<NotificationDTO> findAllUsersNotification(UUID userId, Pageable pageable) {
        Page<Notification> page = notificationRepository.findAllPagedByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageable);
        return page.map(NotificationDTO::new);
    }

    @Override
    @Transactional
    public NotificationDTO updateNotificationStatus(UUID id, UUID userId, NotificationDTO dto) {

        log.debug("updateNotificationStatus notificationId received: {}, UserId Received: {}, dto Received: {} ", id,
                (userId != null ? userId : "UserId not received"),
                (dto != null ? dto : "dto not received"));
        Optional<Notification> obj = notificationRepository.findByIdAndUserId(id, userId);
        Notification entity = obj.orElseThrow(() -> new ResourceNotFoundException("Notification not found. | NotificationId" + id + " | UserId: " + userId));
        if(dto.getNotificationStatus() != null){
            entity.setNotificationStatus(dto.getNotificationStatus());
        }
        notificationRepository.save(entity);

        log.debug("updateNotificationStatus notificationId updated: {}, UserId Updated: {} ", id,
                (userId != null ? userId : "UserId not received"));
        log.info("Notification updated successfully");

        return new NotificationDTO(entity);
    }


    public void copyDtoToEntity(Notification entity, NotificationDTO dto){

        entity.setUserId(dto.getUserId());
        entity.setTitle(dto.getTitle());
        entity.setMessage(dto.getMessage());
        entity.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        entity.setNotificationStatus(NotificationStatus.CREATED);
    }
}
