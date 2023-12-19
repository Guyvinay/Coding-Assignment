package com.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDefinition {
    private LocalDateTime timeStamp;
    private String description;
    private String message;
}
