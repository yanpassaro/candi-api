package com.example.candi.domain.dto;

public record JobDTO(
        Long id,
        String title,
        String description,
        String salary,
        String company
) {
}
