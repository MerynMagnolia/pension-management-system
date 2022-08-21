package com.microservice.pensionerdetailservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PensionerDetailRepository extends JpaRepository<PensionerDetail, Long> {
	PensionerDetail findByAadharNumber(Long aadharNumber);
}
