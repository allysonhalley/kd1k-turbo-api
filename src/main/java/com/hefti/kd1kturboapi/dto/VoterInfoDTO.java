package com.hefti.kd1kturboapi.dto;

public record VoterInfoDTO(
        Long id,
        String number,
        String zone,
        String section,
        String state
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String number;
        private String zone;
        private String section;
        private String state;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder number(String number) { this.number = number; return this; }
        public Builder zone(String zone) { this.zone = zone; return this; }
        public Builder section(String section) { this.section = section; return this; }
        public Builder state(String state) { this.state = state; return this; }

        public VoterInfoDTO build() {
            return new VoterInfoDTO(id, number, zone, section, state);
        }
    }
}