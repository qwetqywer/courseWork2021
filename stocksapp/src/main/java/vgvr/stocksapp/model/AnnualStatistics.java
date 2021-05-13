package vgvr.stocksapp.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "annualstatistics")
public class AnnualStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "capitalization")
    private BigDecimal capitalization;

    @Column(name = "netprofit")
    private BigDecimal netProfit;

    @Column(name = "capital")
    private BigDecimal capital;

    @Column(name = "fcf")
    private BigDecimal FCF;

    @Column(name = "idcompanies")
    private Long idCompany;

    @Column(name = "liabilities")
    private BigDecimal currentLiabilities;

    @Column(name = "termliabilities")
    private BigDecimal termLiabilities;

    @Column(name = "debt")
    private BigDecimal netDebt;

    @Column(name = "assets")
    private BigDecimal assets;

    @Column(name = "totalshares")
    private BigDecimal totalShares;

    @Column(name = "priceshare")
    private BigDecimal priceShare;

}
