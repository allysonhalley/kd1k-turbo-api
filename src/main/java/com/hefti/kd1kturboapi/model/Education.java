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
@Table(name = "education")
public class Education extends BaseEntity {

    @Column
    private String educationLevel;

    @Column
    private String institution;

    @Column
    private String course;

    @Column
    private String period;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", nullable = false)
    private MilitaryPersonnel militaryPersonnel;
}