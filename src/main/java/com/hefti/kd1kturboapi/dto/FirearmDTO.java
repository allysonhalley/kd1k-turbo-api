package com.hefti.kd1kturboapi.dto;

public record FirearmDTO(
        Long id,
        String sigmaNumber,
        String serviceAuthorization
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String sigmaNumber;
        private String serviceAuthorization;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder sigmaNumber(String sigmaNumber) { this.sigmaNumber = sigmaNumber; return this; }
        public Builder serviceAuthorization(String serviceAuthorization) { this.serviceAuthorization = serviceAuthorization; return this; }

        public FirearmDTO build() {
            return new FirearmDTO(id, sigmaNumber, serviceAuthorization);
        }
    }
}