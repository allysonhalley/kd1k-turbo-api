package com.hefti.kd1kturboapi.dto;

import java.time.LocalDate;

public record ContactInfoDTO(
        Long id,
        String email,
        String phone1,
        String phone2,
        String phone3,
        String spouse,
        LocalDate spouseBirthdate
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String email;
        private String phone1;
        private String phone2;
        private String phone3;
        private String spouse;
        private LocalDate spouseBirthdate;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder phone1(String phone1) { this.phone1 = phone1; return this; }
        public Builder phone2(String phone2) { this.phone2 = phone2; return this; }
        public Builder phone3(String phone3) { this.phone3 = phone3; return this; }
        public Builder spouse(String spouse) { this.spouse = spouse; return this; }
        public Builder spouseBirthdate(LocalDate spouseBirthdate) { this.spouseBirthdate = spouseBirthdate; return this; }

        public ContactInfoDTO build() {
            return new ContactInfoDTO(id, email, phone1, phone2, phone3, spouse, spouseBirthdate);
        }
    }
}