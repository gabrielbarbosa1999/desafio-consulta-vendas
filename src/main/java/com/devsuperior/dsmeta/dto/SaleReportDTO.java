package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class SaleReportDTO {

    public final static String PATH = "com.devsuperior.dsmeta.dto.SaleReportDTO";
    private Long id;
    private LocalDate date;
    private double amount;
    private String sellerName;

    public SaleReportDTO(Long id, LocalDate date, double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }
}
