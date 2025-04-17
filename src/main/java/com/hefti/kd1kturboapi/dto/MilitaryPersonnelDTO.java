package com.hefti.kd1kturboapi.dto;

import java.time.LocalDate;
import java.util.List;

public record MilitaryPersonnelDTO(
        Long id,
        String fullName,
        String warName,
        String cpf,
        LocalDate birthDate,
        Integer birthMonth,
        String maritalStatus,
        String gender,
        String religion,
        String bloodType,
        String rhFactor,
        String headSize,
        String shoeSize,
        String bootSize,
        String shirtSize,
        String pantsSize,
        String shortsSize,
        String swimwearSize,
        String swimTrunksSize,
        Boolean organDonor,
        Boolean bloodDonor,
        Boolean casMember,
        Boolean sismepeUser,
        Boolean hasAccidentCertificate,
        Boolean hasChronicDisease,
        Boolean controlledMedication,
        Boolean hasAllergies,
        MilitaryRankDTO rank,
        MilitaryIdentityDTO militaryIdentity,
        ServiceHistoryDTO serviceHistory,
        ParentsDTO parents,
        EducationDTO education,
        AddressDTO address,
        BankInfoDTO bankInfo,
        VoterInfoDTO voterInfo,
        DriversLicenseDTO driversLicense,
        BoatLicenseDTO boatLicense,
        List<FirearmDTO> firearms,
        ContactInfoDTO contactInfo,
        List<DependentDTO> dependents,
        List<QualificationDTO> qualifications,
        WorkLocationDTO workLocation
) {
    // Factory method para criar um builder
    public static Builder builder() {
        return new Builder();
    }

    // Classe Builder interna para facilitar a criação de instâncias
    public static class Builder {
        private Long id;
        private String fullName;
        private String warName;
        private String cpf;
        private LocalDate birthDate;
        private Integer birthMonth;
        private String maritalStatus;
        private String gender;
        private String religion;
        private String bloodType;
        private String rhFactor;
        private String headSize;
        private String shoeSize;
        private String bootSize;
        private String shirtSize;
        private String pantsSize;
        private String shortsSize;
        private String swimwearSize;
        private String swimTrunksSize;
        private Boolean organDonor;
        private Boolean bloodDonor;
        private Boolean casMember;
        private Boolean sismepeUser;
        private Boolean hasAccidentCertificate;
        private Boolean hasChronicDisease;
        private Boolean controlledMedication;
        private Boolean hasAllergies;
        private MilitaryRankDTO rank;
        private MilitaryIdentityDTO militaryIdentity;
        private ServiceHistoryDTO serviceHistory;
        private ParentsDTO parents;
        private EducationDTO education;
        private AddressDTO address;
        private BankInfoDTO bankInfo;
        private VoterInfoDTO voterInfo;
        private DriversLicenseDTO driversLicense;
        private BoatLicenseDTO boatLicense;
        private List<FirearmDTO> firearms;
        private ContactInfoDTO contactInfo;
        private List<DependentDTO> dependents;
        private List<QualificationDTO> qualifications;
        private WorkLocationDTO workLocation;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder fullName(String fullName) { this.fullName = fullName; return this; }
        public Builder warName(String warName) { this.warName = warName; return this; }
        public Builder cpf(String cpf) { this.cpf = cpf; return this; }
        public Builder birthDate(LocalDate birthDate) { this.birthDate = birthDate; return this; }
        public Builder birthMonth(Integer birthMonth) { this.birthMonth = birthMonth; return this; }
        public Builder maritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        public Builder religion(String religion) { this.religion = religion; return this; }
        public Builder bloodType(String bloodType) { this.bloodType = bloodType; return this; }
        public Builder rhFactor(String rhFactor) { this.rhFactor = rhFactor; return this; }
        public Builder headSize(String headSize) { this.headSize = headSize; return this; }
        public Builder shoeSize(String shoeSize) { this.shoeSize = shoeSize; return this; }
        public Builder bootSize(String bootSize) { this.bootSize = bootSize; return this; }
        public Builder shirtSize(String shirtSize) { this.shirtSize = shirtSize; return this; }
        public Builder pantsSize(String pantsSize) { this.pantsSize = pantsSize; return this; }
        public Builder shortsSize(String shortsSize) { this.shortsSize = shortsSize; return this; }
        public Builder swimwearSize(String swimwearSize) { this.swimwearSize = swimwearSize; return this; }
        public Builder swimTrunksSize(String swimTrunksSize) { this.swimTrunksSize = swimTrunksSize; return this; }
        public Builder organDonor(Boolean organDonor) { this.organDonor = organDonor; return this; }
        public Builder bloodDonor(Boolean bloodDonor) { this.bloodDonor = bloodDonor; return this; }
        public Builder casMember(Boolean casMember) { this.casMember = casMember; return this; }
        public Builder sismepeUser(Boolean sismepeUser) { this.sismepeUser = sismepeUser; return this; }
        public Builder hasAccidentCertificate(Boolean hasAccidentCertificate) { this.hasAccidentCertificate = hasAccidentCertificate; return this; }
        public Builder hasChronicDisease(Boolean hasChronicDisease) { this.hasChronicDisease = hasChronicDisease; return this; }
        public Builder controlledMedication(Boolean controlledMedication) { this.controlledMedication = controlledMedication; return this; }
        public Builder hasAllergies(Boolean hasAllergies) { this.hasAllergies = hasAllergies; return this; }
        public Builder rank(MilitaryRankDTO rank) { this.rank = rank; return this; }
        public Builder militaryIdentity(MilitaryIdentityDTO militaryIdentity) { this.militaryIdentity = militaryIdentity; return this; }
        public Builder serviceHistory(ServiceHistoryDTO serviceHistory) { this.serviceHistory = serviceHistory; return this; }
        public Builder parents(ParentsDTO parents) { this.parents = parents; return this; }
        public Builder education(EducationDTO education) { this.education = education; return this; }
        public Builder address(AddressDTO address) { this.address = address; return this; }
        public Builder bankInfo(BankInfoDTO bankInfo) { this.bankInfo = bankInfo; return this; }
        public Builder voterInfo(VoterInfoDTO voterInfo) { this.voterInfo = voterInfo; return this; }
        public Builder driversLicense(DriversLicenseDTO driversLicense) { this.driversLicense = driversLicense; return this; }
        public Builder boatLicense(BoatLicenseDTO boatLicense) { this.boatLicense = boatLicense; return this; }
        public Builder firearms(List<FirearmDTO> firearms) { this.firearms = firearms; return this; }
        public Builder contactInfo(ContactInfoDTO contactInfo) { this.contactInfo = contactInfo; return this; }
        public Builder dependents(List<DependentDTO> dependents) { this.dependents = dependents; return this; }
        public Builder qualifications(List<QualificationDTO> qualifications) { this.qualifications = qualifications; return this; }
        public Builder workLocation(WorkLocationDTO workLocation) { this.workLocation = workLocation; return this; }

        public MilitaryPersonnelDTO build() {
            return new MilitaryPersonnelDTO(
                    id, fullName, warName, cpf, birthDate, birthMonth, maritalStatus, gender, religion,
                    bloodType, rhFactor, headSize, shoeSize, bootSize, shirtSize, pantsSize, shortsSize,
                    swimwearSize, swimTrunksSize, organDonor, bloodDonor, casMember, sismepeUser,
                    hasAccidentCertificate, hasChronicDisease, controlledMedication, hasAllergies,
                    rank, militaryIdentity, serviceHistory, parents, education, address, bankInfo,
                    voterInfo, driversLicense, boatLicense, firearms, contactInfo, dependents,
                    qualifications, workLocation
            );
        }
    }
}