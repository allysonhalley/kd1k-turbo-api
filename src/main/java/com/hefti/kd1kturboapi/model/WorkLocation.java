package com.hefti.kd1kturboapi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "work_location")
public class WorkLocation extends BaseEntity {

    @Column(nullable = false)
    private String schedule;

    @Column(name = "reduced_work_hours")
    private Boolean reducedWorkHours;

    @Column
    private Boolean readapted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", nullable = false)
    private MilitaryPeople militaryPeople;
}