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
public class AccountDto {
	private String accountId;
	private Double balanace;
	private String dateCreated;
	private String dateUpdated;
    private String customerId;

}
