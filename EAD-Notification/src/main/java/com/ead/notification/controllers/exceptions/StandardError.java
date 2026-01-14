package com.ead.notification.controllers.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StandardError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
