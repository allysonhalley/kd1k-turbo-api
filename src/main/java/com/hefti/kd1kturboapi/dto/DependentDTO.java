package com.hefti.kd1kturboapi.dto;

import java.time.LocalDate;

public record DependentDTO(
        Long id,
        String name,
        LocalDate birthDate
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private LocalDate birthDate;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder birthDate(LocalDate birthDate) { this.birthDate = birthDate; return this; }

        public DependentDTO build() {
            return new DependentDTO(id, name, birthDate);
        }
    }
}