package com.hefti.kd1kturboapi.dto;

public record BankInfoDTO(
        Long id,
        String bank,
        String branch,
        String accountType,
        String account,
        String digit
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String bank;
        private String branch;
        private String accountType;
        private String account;
        private String digit;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder bank(String bank) { this.bank = bank; return this; }
        public Builder branch(String branch) { this.branch = branch; return this; }
        public Builder accountType(String accountType) { this.accountType = accountType; return this; }
        public Builder account(String account) { this.account = account; return this; }
        public Builder digit(String digit) { this.digit = digit; return this; }

        public BankInfoDTO build() {
            return new BankInfoDTO(id, bank, branch, accountType, account, digit);
        }
    }
}