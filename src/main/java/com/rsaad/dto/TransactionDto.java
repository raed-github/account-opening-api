package com.rsaad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class TransactionDto {
	private String transactionId;
	private String transactionType;
	private Double amount;
    private String currency;
    private String fromAccount;
    private String toAccount;
	private String transactionDate;
	private String dateCreated;
	private String dateUpdated;
	private String accountId;

}
