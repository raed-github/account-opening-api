package com.rsaad.dto;

import java.util.Set;

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
public class CustomerDto {
	private String customerId;
	private String name;
	private String surName;
	private Set<String> accounts;
	private String dateCreated;
	private String dateUpdated;

}
