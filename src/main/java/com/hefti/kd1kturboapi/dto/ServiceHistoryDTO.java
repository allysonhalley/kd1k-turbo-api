package com.hefti.kd1kturboapi.dto;

import java.time.LocalDate;

public record ServiceHistoryDTO(
        Long id,
        LocalDate entryDate,
        Integer serviceTime,
        Integer accumulatedDays,
        Integer totalDays,
        String totalTime,
        LocalDate arrivalDate,
        String arrivalDocument,
        LocalDate lastPromotionDate,
        String coaph,
        String crvcm,
        String rmp,
        String mbm
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private LocalDate entryDate;
        private Integer serviceTime;
        private Integer accumulatedDays;
        private Integer totalDays;
        private String totalTime;
        private LocalDate arrivalDate;
        private String arrivalDocument;
        private LocalDate lastPromotionDate;
        private String coaph;
        private String crvcm;
        private String rmp;
        private String mbm;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder entryDate(LocalDate entryDate) { this.entryDate = entryDate; return this; }
        public Builder serviceTime(Integer serviceTime) { this.serviceTime = serviceTime; return this; }
        public Builder accumulatedDays(Integer accumulatedDays) { this.accumulatedDays = accumulatedDays; return this; }
        public Builder totalDays(Integer totalDays) { this.totalDays = totalDays; return this; }
        public Builder totalTime(String totalTime) { this.totalTime = totalTime; return this; }
        public Builder arrivalDate(LocalDate arrivalDate) { this.arrivalDate = arrivalDate; return this; }
        public Builder arrivalDocument(String arrivalDocument) { this.arrivalDocument = arrivalDocument; return this; }
        public Builder lastPromotionDate(LocalDate lastPromotionDate) { this.lastPromotionDate = lastPromotionDate; return this; }
        public Builder coaph(String coaph) { this.coaph = coaph; return this; }
        public Builder crvcm(String crvcm) { this.crvcm = crvcm; return this; }
        public Builder rmp(String rmp) { this.rmp = rmp; return this; }
        public Builder mbm(String mbm) { this.mbm = mbm; return this; }

        public ServiceHistoryDTO build() {
            return new ServiceHistoryDTO(id, entryDate, serviceTime, accumulatedDays, totalDays, totalTime, arrivalDate, arrivalDocument, lastPromotionDate, coaph, crvcm, rmp, mbm);
        }
    }
}
