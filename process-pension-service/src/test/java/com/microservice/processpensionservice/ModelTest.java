package com.microservice.processpensionservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModelTest {

	@Test
	void testNoArgsBankDetailTest() {
		assertThat(new BankDetail()).isNotNull();
	}

	@Test
	void testAllArgsBankDetailTest() {
		BankDetail bankDetails = new BankDetail("ICICI", "1234567890", "Private");
		assertNotNull(bankDetails);
	}

	@Test
	void testSetterBankTest() {
		BankDetail b = new BankDetail();
		b.setAccountNumber("S00101");
		b.setBankName("ICICI");
		b.setBankType("public");
		assertThat(assertThat(b).isNotNull());
	}

	@Test
	void SetterArgsBankDetailTest() {
		BankDetail bankDetails = new BankDetail("ICICI", "1234567890", "private");
		assertEquals("ICICI", bankDetails.getBankName());
		assertEquals("1234567890", bankDetails.getAccountNumber());
		assertEquals("private", bankDetails.getBankType());
	}

	@Test
	void testSetterprocessPensionTest() {
		ProcessPension processPension = new ProcessPension();
		processPension.setId(100L);
		processPension.setPensionerName("Justin");
		processPension.setAadharNumber(948820870619L);
		processPension.setDob(new Date());
		processPension.setPan("GTYIK7412L");
		processPension.setLastSalary(10000);
		processPension.setAllowances(500);
		processPension.setPensionType("family");

		BankDetail bankDetail = new BankDetail();
		bankDetail.setAccountNumber("102233445566");
		bankDetail.setBankName("ICICI");
		bankDetail.setBankType("public");

		processPension.setBankDetail(bankDetail);
		assertThat(assertThat(processPension).isNotNull());

		assertEquals(100L, processPension.getId());
		assertEquals("Justin", processPension.getPensionerName());
		assertEquals(948820870619L, processPension.getAadharNumber());
//		assertEquals(new Date(), processPension.getDob());
		assertEquals("GTYIK7412L", processPension.getPan());
		assertEquals(10000, processPension.getLastSalary());
		assertEquals(500, processPension.getAllowances());
		assertEquals("family", processPension.getPensionType());

		assertEquals("102233445566", bankDetail.getAccountNumber());
		assertEquals("ICICI", bankDetail.getBankName());
		assertEquals("public", bankDetail.getBankType());
	}

	@Test
	void testGetterprocessPensionTest() {
		BankDetail b = new BankDetail("102233445566", "SBI", "public");
		ProcessPension p = new ProcessPension(100L, "Justin", 948820870619L, new Date(), "GTYIK7412L", 10000, 550,
				"family", 0L, b);
		assertThat(assertThat(p).isNotNull());
		assertEquals("Justin", p.getPensionerName());
		assertEquals(948820870619L, p.getAadharNumber());

	}

}
