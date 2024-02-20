package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SallerSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new " + SaleReportDTO.PATH + "(sale.id, sale.date, sale.amount, seller.name) FROM Sale sale " +
            "JOIN sale.seller seller " +
            "WHERE sale.date >= :minDate AND sale.date <= :maxDate " +
            "AND UPPER(seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<SaleReportDTO> findReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);

    @Query("SELECT new " + SallerSummaryDTO.PATH + "(seller.name, SUM(sale.amount)) FROM Sale sale " +
            "JOIN sale.seller seller " +
            "WHERE sale.date >= :minDate AND sale.date <= :maxDate " +
            "AND UPPER(seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
            "GROUP BY seller.name")
    Page<SallerSummaryDTO> findSummary(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);


}
