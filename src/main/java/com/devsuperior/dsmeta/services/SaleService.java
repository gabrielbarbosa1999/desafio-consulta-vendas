package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SallerSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    public Page<SaleReportDTO> getReport(String minDate, String maxDate, String name, Pageable pageable) {
        LocalDate dataAtual = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate dataInicial;
        LocalDate dataFinal;
        if (minDate.isBlank()) {
            dataInicial = dataAtual.minusYears(1L);
        } else {
            dataInicial = LocalDate.parse(minDate);
        }
        if (maxDate.isBlank()) {
            dataFinal = dataAtual;
        } else {
            dataFinal = LocalDate.parse(maxDate);
        }
        return repository.findReport(dataInicial, dataFinal, name, pageable);
    }

    public Page<SallerSummaryDTO> getSummary(String minDate, String maxDate, String name, Pageable pageable) {
        LocalDate dataAtual = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate dataInicial;
        LocalDate dataFinal;
        if (minDate.isBlank()) {
            dataInicial = dataAtual.minusYears(1L);
        } else {
            dataInicial = LocalDate.parse(minDate);
        }
        if (maxDate.isBlank()) {
            dataFinal = dataAtual;
        } else {
            dataFinal = LocalDate.parse(maxDate);
        }
        return repository.findSummary(dataInicial, dataFinal, name, pageable);
    }

}
