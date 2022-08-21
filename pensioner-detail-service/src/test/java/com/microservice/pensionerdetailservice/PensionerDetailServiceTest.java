package com.microservice.pensionerdetailservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PensionerDetailServiceTest.class)
@AutoConfigureMockMvc
class PensionerDetailServiceTest {

	@InjectMocks
	PensionerDetailService pdService;

	@Mock
	PensionerDetailRepository pensionerDetailRepo;

	@Mock
	PensionerDetail pensionerDetail;

	@Mock
	BankDetail bankDetail;
	
	@Mock
	PensionerDetailController pdController;

	BankDetail b = new BankDetail("102233445566", "SBI", "public");
	PensionerDetail p = new PensionerDetail(100L, "Justin", 948820870619L, new Date(), "GTYIK7412L", 10000, 550,
			"family", 0L, b);
	
	@Test
	public void RepoTest() {

		when(pensionerDetailRepo.findByAadharNumber(948820870619L)).thenReturn(p);
		assertEquals(10000, p.getLastSalary());
		assertEquals(550, p.getAllowances());

		when(pensionerDetailRepo.findByAadharNumber(948820870610L)).thenReturn(p);
		assertEquals("Unable to find data for Aadhar Number : 948820870610", p, p);
	}
	
	@Test
	public void serviceCall() {
		when(pdService.findByAadhar(948820870619L)).thenReturn(p);
		assertEquals(10000, p.getLastSalary());
		
	}
	
//	@Test
//	public void controllerTest() throws Exception {
//		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBcnVsIiwiZXhwIjoxNjYwNTU1NjY0LCJpYXQiOjE2NjA1NDM2NjR9.-XD1V14Yz8AnAqOpaX8gd5Aop6-hNhu26e8EURLLwJfLbvClUzyHwvJh8X30zk8UcI_CFqtkMBe3YOschQTfZw";
//		when(pdController.retrievePensionerDetail(token, 948820870619L)).thenReturn(p);
//		assertEquals(10000, p.getLastSalary());
//		
//	}

}
