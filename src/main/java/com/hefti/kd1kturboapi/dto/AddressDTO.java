package com.hefti.kd1kturboapi.dto;

public record AddressDTO(
        Long id,
        String zipCode,
        String street,
        String number,
        String complement,
        String reference,
        String neighborhood,
        String city,
        String state
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String zipCode;
        private String street;
        private String number;
        private String complement;
        private String reference;
        private String neighborhood;
        private String city;
        private String state;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder zipCode(String zipCode) { this.zipCode = zipCode; return this; }
        public Builder street(String street) { this.street = street; return this; }
        public Builder number(String number) { this.number = number; return this; }
        public Builder complement(String complement) { this.complement = complement; return this; }
        public Builder reference(String reference) { this.reference = reference; return this; }
        public Builder neighborhood(String neighborhood) { this.neighborhood = neighborhood; return this; }
        public Builder city(String city) { this.city = city; return this; }
        public Builder state(String state) { this.state = state; return this; }

        public AddressDTO build() {
            return new AddressDTO(id, zipCode, street, number, complement, reference, neighborhood, city, state);
        }
    }
}