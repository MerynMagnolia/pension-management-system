package com.microservice.processpensionservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProcessPensionServiceTest.class })
class ProcessPensionServiceTest {

	@MockBean
	ProcessPensionService ppService;

	BankDetail b = new BankDetail("102233445566", "SBI", "public");
	ProcessPension p = new ProcessPension(100L, "Justin", 948820870619L, new Date(), "GTYIK7412L", 20000, 550, "family",
			0L, b);

	@Test
	void bankTypeTest1() {

		ProcessPension pp = new ProcessPension();
//		b.setBankType("public");
//		pp.setAllowances(550);
//		pp.setLastSalary(1000);
//		pp.setPensionType("family");
//		pp.setBankDetail(b);
		when(ppService.calculatePension(p)).thenReturn(pp);
//		System.out.println(pp.getPensionAmount());
//		assertThat(assertThat(pp).isNotNull());
//		assertEquals(5050, pp.getPensionAmount());
	}

}
