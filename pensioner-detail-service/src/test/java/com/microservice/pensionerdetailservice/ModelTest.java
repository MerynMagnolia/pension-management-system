package com.microservice.pensionerdetailservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModelTest {

	@Mock
	PensionerDetail pensionerDetail;

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
	void testSetterPensionerDetailTest() {
		PensionerDetail pensionerDetail = new PensionerDetail();
		pensionerDetail.setId(100L);
		pensionerDetail.setPensionerName("Justin");
		pensionerDetail.setAadharNumber(948820870619L);
		pensionerDetail.setDob(new Date());
		pensionerDetail.setPan("GTYIK7412L");
		pensionerDetail.setLastSalary(10000);
		pensionerDetail.setAllowances(500);
		pensionerDetail.setPensionType("family");

		BankDetail bankDetail = new BankDetail();
		bankDetail.setAccountNumber("102233445566");
		bankDetail.setBankName("ICICI");
		bankDetail.setBankType("public");

		pensionerDetail.setBankDetail(bankDetail);
		assertThat(assertThat(pensionerDetail).isNotNull());

		assertEquals(100L, pensionerDetail.getId());
		assertEquals("Justin", pensionerDetail.getPensionerName());
		assertEquals(948820870619L, pensionerDetail.getAadharNumber());
		assertEquals(new Date(), pensionerDetail.getDob());
		assertEquals("GTYIK7412L", pensionerDetail.getPan());
		assertEquals(10000, pensionerDetail.getLastSalary());
		assertEquals(500, pensionerDetail.getAllowances());
		assertEquals("family", pensionerDetail.getPensionType());

		assertEquals("102233445566", bankDetail.getAccountNumber());
		assertEquals("ICICI", bankDetail.getBankName());
		assertEquals("public", bankDetail.getBankType());
	}

	@Test
	void testGetterPensionerDetailTest() {
		BankDetail b = new BankDetail("SBI", "102233445566", "public");
		PensionerDetail p = new PensionerDetail(100L, "Justin", 948820870619L, new Date(), "GTYIK7412L", 10000, 550,
				"family", 0L, b);
		assertThat(assertThat(p).isNotNull());
		assertEquals("Justin", p.getPensionerName());
		assertEquals(948820870619L, p.getAadharNumber());
		assertEquals("GTYIK7412L", p.getPan());
		assertEquals(10000, p.getLastSalary());
		assertEquals(550, p.getAllowances());
		assertEquals("family", p.getPensionType());

		assertEquals("SBI", p.getBankDetail().getBankName());
		assertEquals("102233445566", p.getBankDetail().getAccountNumber());
		assertEquals("public", p.getBankDetail().getBankType());


	}

}
