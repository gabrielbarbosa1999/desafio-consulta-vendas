package com.devsuperior.dsmeta.dto;

public class SallerSummaryDTO {
    public final static String PATH = "com.devsuperior.dsmeta.dto.SallerSummaryDTO";
    private String sellerName;
    private Double total;

    public SallerSummaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }
}
