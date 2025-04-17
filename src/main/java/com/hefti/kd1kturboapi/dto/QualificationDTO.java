package com.hefti.kd1kturboapi.dto;

public record QualificationDTO(
        Long id,
        String course,
        String location
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String course;
        private String location;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder course(String course) { this.course = course; return this; }
        public Builder location(String location) { this.location = location; return this; }

        public QualificationDTO build() {
            return new QualificationDTO(id, course, location);
        }
    }
}