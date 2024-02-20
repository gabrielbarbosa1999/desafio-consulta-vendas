package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SallerSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleReportDTO>> getReport(@RequestParam(defaultValue = "") String minDate, @RequestParam(defaultValue = "") String maxDate, @RequestParam(defaultValue = "") String name, Pageable pageable) {
		Page<SaleReportDTO> report = service.getReport(minDate, maxDate, name, pageable);
		return ResponseEntity.ok(report);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SallerSummaryDTO>> getSummary(@RequestParam(defaultValue = "") String minDate, @RequestParam(defaultValue = "") String maxDate, @RequestParam(defaultValue = "") String name, Pageable pageable) {
		Page<SallerSummaryDTO> summary = service.getSummary(minDate, maxDate, name, pageable);
		return ResponseEntity.ok(summary);
	}
}
