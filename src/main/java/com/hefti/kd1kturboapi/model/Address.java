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
@Table(name = "address")
public class Address extends BaseEntity {

    @Column
    private String zipCode;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String complement;

    @Column
    private String reference;

    @Column
    private String neighborhood;

    @Column
    private String city;

    @Column
    private String state;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", nullable = false)
    private MilitaryPeople militaryPeople;
}