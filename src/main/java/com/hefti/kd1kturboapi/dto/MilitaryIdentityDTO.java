package com.hefti.kd1kturboapi.dto;

import java.time.LocalDate;

public record MilitaryIdentityDTO(
        Long id,
        String number,
        String issuingAgency,
        String state,
        LocalDate issueDate,
        LocalDate validUntil,
        String registration
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String number;
        private String issuingAgency;
        private String state;
        private LocalDate issueDate;
        private LocalDate validUntil;
        private String registration;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder number(String number) { this.number = number; return this; }
        public Builder issuingAgency(String issuingAgency) { this.issuingAgency = issuingAgency; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder issueDate(LocalDate issueDate) { this.issueDate = issueDate; return this; }
        public Builder validUntil(LocalDate validUntil) { this.validUntil = validUntil; return this; }
        public Builder registration(String registration) { this.registration = registration; return this; }

        public MilitaryIdentityDTO build() {
            return new MilitaryIdentityDTO(id, number, issuingAgency, state, issueDate, validUntil, registration);
        }
    }
}