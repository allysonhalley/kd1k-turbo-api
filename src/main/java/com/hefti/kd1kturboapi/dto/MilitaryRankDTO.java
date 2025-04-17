package com.hefti.kd1kturboapi.dto;

public record MilitaryRankDTO(
        Long id,
        Integer number,
        String rankAbbreviation,
        String rankName,
        String branch
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Integer number;
        private String rankAbbreviation;
        private String rankName;
        private String branch;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder number(Integer number) { this.number = number; return this; }
        public Builder rankAbbreviation(String rankAbbreviation) { this.rankAbbreviation = rankAbbreviation; return this; }
        public Builder rankName(String rankName) { this.rankName = rankName; return this; }
        public Builder branch(String branch) { this.branch = branch; return this; }

        public MilitaryRankDTO build() {
            return new MilitaryRankDTO(id, number, rankAbbreviation, rankName, branch);
        }
    }
}