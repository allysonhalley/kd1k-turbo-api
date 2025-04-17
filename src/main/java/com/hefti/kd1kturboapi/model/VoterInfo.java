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
@Table(name = "voter_info")
public class VoterInfo extends BaseEntity {

    @Column
    private String number;

    @Column
    private String zone;

    @Column
    private String section;

    @Column
    private String state;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", nullable = false)
    private MilitaryPersonnel militaryPersonnel;
}
