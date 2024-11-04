package com.example.api.db.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Sample {
    private Long seq;
    private String id;
    private Integer number;
    private String string;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
