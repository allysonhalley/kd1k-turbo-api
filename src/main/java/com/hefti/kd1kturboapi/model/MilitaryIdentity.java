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
@Table(name = "military_identity")
public class MilitaryIdentity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String number;

    @Column(name = "issuing_agency")
    private String issuingAgency;

    @Column
    private String state;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column
    private LocalDate validUntil;

    @Column(nullable = false, unique = true)
    private String registration;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", nullable = false)
    private MilitaryPersonnel militaryPersonnel;
}
