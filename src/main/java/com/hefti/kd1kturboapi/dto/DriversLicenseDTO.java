package com.hefti.kd1kturboapi.dto;

import java.time.LocalDate;

public record DriversLicenseDTO(
        Long id,
        String registration,
        String state,
        LocalDate validUntil,
        String category,
        LocalDate firstLicenseDate,
        LocalDate issueDate
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String registration;
        private String state;
        private LocalDate validUntil;
        private String category;
        private LocalDate firstLicenseDate;
        private LocalDate issueDate;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder registration(String registration) { this.registration = registration; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder validUntil(LocalDate validUntil) { this.validUntil = validUntil; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder firstLicenseDate(LocalDate firstLicenseDate) { this.firstLicenseDate = firstLicenseDate; return this; }
        public Builder issueDate(LocalDate issueDate) { this.issueDate = issueDate; return this; }

        public DriversLicenseDTO build() {
            return new DriversLicenseDTO(id, registration, state, validUntil, category, firstLicenseDate, issueDate);
        }
    }
}