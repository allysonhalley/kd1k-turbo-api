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
@Table(name = "qualification")
public class Qualification extends BaseEntity {

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", nullable = false)
    private MilitaryPersonnel militaryPersonnel;
}