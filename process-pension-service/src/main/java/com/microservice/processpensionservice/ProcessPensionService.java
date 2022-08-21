package com.microservice.processpensionservice;

import org.springframework.stereotype.Service;

@Service
public class ProcessPensionService {

	public ProcessPension calculatePension(ProcessPension pensionerDetail) {
		int bankCharge = 0;
		if (pensionerDetail.getBankDetail().getBankType().equalsIgnoreCase("public")) {
			bankCharge = 500;
		} else {
			bankCharge = 550;
		}

		float pensionAmt = 0;
		int lastSal = pensionerDetail.getLastSalary();
		if (pensionerDetail.getPensionType().equalsIgnoreCase("self")) {
			pensionAmt = (float) ((80.0 * lastSal) / 100);
		} else {
			pensionAmt = (float) ((50.0 * lastSal) / 100);
		}

		Long TotAmt = (long) (pensionAmt + pensionerDetail.getAllowances() - bankCharge);
		pensionerDetail.setPensionAmount(TotAmt);

		System.out.println(bankCharge + ":" + pensionAmt + ":" + TotAmt);

//		Pro pension = pensionerRepo.save(pensionerDetail);
		return pensionerDetail;
	}

}
