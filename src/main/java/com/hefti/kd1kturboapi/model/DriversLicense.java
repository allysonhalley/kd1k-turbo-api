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
@Table(name = "drivers_license")
public class DriversLicense extends BaseEntity {

    @Column
    private String registration;

    @Column
    private String state;

    @Column
    private LocalDate validUntil;

    @Column
    private String category;

    @Column(name = "first_license_date")
    private LocalDate firstLicenseDate;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", nullable = false)
    private MilitaryPersonnel militaryPersonnel;
}