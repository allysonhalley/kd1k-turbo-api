package com.hefti.kd1kturboapi.dto;

public record EducationDTO(
        Long id,
        String educationLevel,
        String institution,
        String course,
        String period
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String educationLevel;
        private String institution;
        private String course;
        private String period;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder educationLevel(String educationLevel) { this.educationLevel = educationLevel; return this; }
        public Builder institution(String institution) { this.institution = institution; return this; }
        public Builder course(String course) { this.course = course; return this; }
        public Builder period(String period) { this.period = period; return this; }

        public EducationDTO build() {
            return new EducationDTO(id, educationLevel, institution, course, period);
        }
    }
}
