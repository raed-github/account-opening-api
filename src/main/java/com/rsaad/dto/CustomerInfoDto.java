package com.rsaad.dto;

import java.util.List;

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
public class CustomerInfoDto {

	private String customerId;
	private String name;
	private String surName;
	private List<TransactionDto> transactions;
}
