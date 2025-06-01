package com.hefti.kd1kturboapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "service_history")
public class ServiceHistory extends BaseEntity {

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "service_time")
    private Integer serviceTime;

    @Column(name = "accumulated_days")
    private Integer accumulatedDays;

    @Column(name = "total_days")
    private Integer totalDays;

    @Column(name = "total_time")
    private String totalTime;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_document")
    private String arrivalDocument;

    @Column(name = "last_promotion_date")
    private LocalDate lastPromotionDate;

    @Column
    private String coaph;

    @Column
    private String crvcm;

    @Column
    private String rmp;

    @Column
    private String mbm;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", nullable = false)
    private MilitaryPeople militaryPeople;
}