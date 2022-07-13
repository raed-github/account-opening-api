package com.rsaad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "TRANSACTION")
@Table(name = "TRANSACTION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class Transaction {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
    @Column(name = "TRANSACTION_TYPE")
	private String transactionType;
    @Column(name = "AMOUNT")
	private Double amount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "FROM_ACCOUNT")
    private String fromAccount;
    @Column(name = "TO_ACCOUNT")
    private String toAccount;
    @Column(name = "TRANSACTION_DATE")
	private String transactionDate;
    @Column(name = "DATA_CREATED")
	private String dateCreated;
    @Column(name = "DATA_UPDATED")
	private String dateUpdated;
    @Column(name = "ACCOUNT_ID")
    private String accountId;

}
