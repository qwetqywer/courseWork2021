package vgvr.stocksapp.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Multipliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "pe")
    private BigDecimal pe;
    @Column(name = "ep")
    private BigDecimal ep;
    @Column(name = "pb")
    private BigDecimal pb;
    @Column(name = "ps")
    private BigDecimal ps;
    @Column(name = "pfcf")
    private BigDecimal pfcf;
    @Column(name = "netdebtebitda")
    private BigDecimal netdebtebitda;
    @Column(name = "id_company")
    private Long idcompany;
}
