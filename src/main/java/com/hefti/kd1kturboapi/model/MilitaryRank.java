package com.hefti.kd1kturboapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "military_rank")
public class MilitaryRank extends BaseEntity {

    @Column(nullable = false)
    private Integer number;

    @Column(name = "rank_abbreviation", nullable = false)
    private String rankAbbreviation;

    @Column(name = "rank_name", nullable = false)
    private String rankName;

    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "rank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MilitaryPeople> people = new ArrayList<>();
}