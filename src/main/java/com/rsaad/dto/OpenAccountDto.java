package com.rsaad.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class OpenAccountDto {
	@NotNull(message = "Customer id is required")
	private String customerId;
	@NotNull
	@Min(value = 0, message = "Balance must be greater than zero")
	private double balance;		
}
