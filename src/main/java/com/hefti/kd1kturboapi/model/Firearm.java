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
@Table(name = "firearm")
public class Firearm extends BaseEntity {

    @Column(name = "sigma_number")
    private String sigmaNumber;

    @Column(name = "service_authorization")
    private String serviceAuthorization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", nullable = false)
    private MilitaryPeople militaryPeople;
}