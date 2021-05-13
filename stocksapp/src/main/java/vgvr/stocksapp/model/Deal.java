package vgvr.stocksapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deal")
public class Deal {

    private static String tickerCompany;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddeal")
    private Long id;

    @Column(name = "idcompany")
    private Long companyId;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "commission")
    private int commission;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "iduser")
    private Long userId;

    @Column(name = "idportfolio")
    private Long portfolioId;

    public static String getTickerCompany() {
        return tickerCompany;
    }

    public static void setTickerCompany(String tickerCompany) {
        Deal.tickerCompany = tickerCompany;
    }
}
