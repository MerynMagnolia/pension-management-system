package com.microservice.processpensionservice;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPension {
	private Long id;
	private String pensionerName;
	private Long aadharNumber;
	private Date dob;
	private String pan;
	private int lastSalary;
	private int allowances;
	private String pensionType;
	private Long pensionAmount;
	
	private BankDetail bankDetail;

}
