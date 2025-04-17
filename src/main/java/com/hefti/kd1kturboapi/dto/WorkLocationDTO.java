package com.hefti.kd1kturboapi.dto;

public record WorkLocationDTO(
        Long id,
        String schedule,
        Boolean reducedWorkHours,
        Boolean readapted
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String schedule;
        private Boolean reducedWorkHours;
        private Boolean readapted;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder schedule(String schedule) { this.schedule = schedule; return this; }
        public Builder reducedWorkHours(Boolean reducedWorkHours) { this.reducedWorkHours = reducedWorkHours; return this; }
        public Builder readapted(Boolean readapted) { this.readapted = readapted; return this; }

        public WorkLocationDTO build() {
            return new WorkLocationDTO(id, schedule, reducedWorkHours, readapted);
        }
    }
}