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

@Entity(name = "ACCOUNT")
@Table(name = "ACCOUNT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class Account {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
    @Column(name = "BALANCE")
	private Double balanace;
    @Column(name = "DATA_CREATED")
	private String dateCreated;
    @Column(name = "DATA_UPDATED")
	private String dateUpdated;
    @Column(name = "CUSTOMER_ID")
    private String customerId;

}
