package com.hefti.kd1kturboapi.dto;

public record BoatLicenseDTO(
        Long id,
        String number
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String number;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder number(String number) { this.number = number; return this; }

        public BoatLicenseDTO build() {
            return new BoatLicenseDTO(id, number);
        }
    }
}