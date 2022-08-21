package com.microservice.pensionerdetailservice;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PensionerDetail {
	@Id
	private Long id;
	private String pensionerName;
	private Long aadharNumber;
	private Date dob;
	private String pan;
	private int lastSalary;
	private int allowances;
	private String pensionType;
	private Long pensionAmount;
	@Embedded
	private BankDetail bankDetail;
	
}
