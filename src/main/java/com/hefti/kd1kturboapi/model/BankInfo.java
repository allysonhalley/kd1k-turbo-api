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
@Table(name = "bank_info")
public class BankInfo extends BaseEntity {

    @Column
    private String bank;

    @Column
    private String branch;

    @Column(name = "account_type")
    private String accountType;

    @Column
    private String account;

    @Column
    private String digit;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", nullable = false)
    private MilitaryPersonnel militaryPersonnel;
}