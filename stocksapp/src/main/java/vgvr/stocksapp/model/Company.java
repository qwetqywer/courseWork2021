package vgvr.stocksapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "companies")
public class Company {
    private static Long companyId;

    public static Long getCompanyId() {
        return companyId;
    }

    public static void setCompanyId(Long companyId) {
        Company.companyId = companyId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompanies")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ticker")
    private String ticker;

}
