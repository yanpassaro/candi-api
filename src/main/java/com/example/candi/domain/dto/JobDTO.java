package com.example.candi.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record JobDTO(
        Long id,
        @Size(min = 3, max = 50) @NotNull
        String title,
        @Size(min = 3, max = 100) @NotNull
        String description,
        @Size(min = 3, max = 10) @NotNull
        String salary,
        @Size(min = 3, max = 50) @NotNull
        String company

) {
}
