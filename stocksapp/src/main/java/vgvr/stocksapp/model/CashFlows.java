package vgvr.stocksapp.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cashflows")
public class CashFlows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "revenue")
    private BigDecimal revenue;
    @Column(name = "profit")
    private BigDecimal profit;
    @Column(name = "ebitda")
    private BigDecimal ebitda;
    @Column(name = "operatingcashflow")
    private BigDecimal operatingcashflow;
    @Column(name = "freecashflow")
    private BigDecimal freecashflow;
    @Column(name = "eps")
    private BigDecimal eps;
    @Column(name = "companyid")
    private Long idcompany;




}
