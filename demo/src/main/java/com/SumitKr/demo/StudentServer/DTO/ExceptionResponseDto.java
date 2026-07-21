package com.SumitKr.demo.StudentServer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private String message;
}