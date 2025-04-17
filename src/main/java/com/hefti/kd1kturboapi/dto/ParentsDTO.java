package com.hefti.kd1kturboapi.dto;

public record ParentsDTO(
        Long id,
        String motherName,
        String fatherName,
        String nationality,
        String birthplace,
        String state
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String motherName;
        private String fatherName;
        private String nationality;
        private String birthplace;
        private String state;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder motherName(String motherName) { this.motherName = motherName; return this; }
        public Builder fatherName(String fatherName) { this.fatherName = fatherName; return this; }
        public Builder nationality(String nationality) { this.nationality = nationality; return this; }
        public Builder birthplace(String birthplace) { this.birthplace = birthplace; return this; }
        public Builder state(String state) { this.state = state; return this; }

        public ParentsDTO build() {
            return new ParentsDTO(id, motherName, fatherName, nationality, birthplace, state);
        }
    }
}