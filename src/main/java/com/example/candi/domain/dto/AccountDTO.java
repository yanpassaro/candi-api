package com.example.candi.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AccountDTO(
        Long id,
        @Email
        String email,
        @Size(min = 3, max = 50) @NotNull
        String name,
        @Size(min = 3, max = 50) @NotNull
        String token

) {
}
