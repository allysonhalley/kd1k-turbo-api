package com.hefti.kd1kturboapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
@Table(name = "military_personnel")
public class MilitaryPersonnel extends BaseEntity {

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "war_name", nullable = false)
    private String warName;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "birth_month")
    private Integer birthMonth;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column
    private String gender;

    @Column
    private String religion;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "rh_factor")
    private String rhFactor;

    @Column(name = "head_size")
    private String headSize;

    @Column(name = "shoe_size")
    private String shoeSize;

    @Column(name = "boot_size")
    private String bootSize;

    @Column(name = "shirt_size")
    private String shirtSize;

    @Column(name = "pants_size")
    private String pantsSize;

    @Column(name = "shorts_size")
    private String shortsSize;

    @Column(name = "swimwear_size")
    private String swimwearSize;

    @Column(name = "swim_trunks_size")
    private String swimTrunksSize;

    @Column(name = "organ_donor")
    private Boolean organDonor;

    @Column(name = "blood_donor")
    private Boolean bloodDonor;

    @Column(name = "cas_member")
    private Boolean casMember;

    @Column(name = "sismepe_user")
    private Boolean sismepeUser;

    @Column(name = "has_accident_certificate")
    private Boolean hasAccidentCertificate;

    @Column(name = "has_chronic_disease")
    private Boolean hasChronicDisease;

    @Column(name = "controlled_medication")
    private Boolean controlledMedication;

    @Column(name = "has_allergies")
    private Boolean hasAllergies;

    // Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id")
    private MilitaryRank rank;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MilitaryIdentity militaryIdentity;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ServiceHistory serviceHistory;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Parents parents;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Education education;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BankInfo bankInfo;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VoterInfo voterInfo;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DriversLicense driversLicense;

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BoatLicense boatLicense;

    @OneToMany(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Firearm> firearms = new ArrayList<>();

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Dependent> dependents = new ArrayList<>();

    @OneToMany(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Qualification> qualifications = new ArrayList<>();

    @OneToOne(mappedBy = "militaryPersonnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WorkLocation workLocation;
}