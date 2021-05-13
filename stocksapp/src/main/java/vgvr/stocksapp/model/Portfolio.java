package vgvr.stocksapp.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Random;

@Data
@Entity
@Table(name = "promotional_portfolio")
public class Portfolio {

    private static Long portfolioId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpromotional_portfolio")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "unique_name")
    private String uniqueName;
    @Column(name = "tax_rate")
    private int taxRate;
    @Column(name = "broker_commission_rate")
    private int commissionRate;
    @Column(name = "id")
    private Long userId;

    public void generateUniqueName(String portfolioName)
    {
        String randomStrings;
        Random random = new Random();
            char[] word = new char[random.nextInt(8)+3];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings = new String(word);

        this.uniqueName = portfolioName + randomStrings;
    }

    public static Long getPortfolioId() {
        return portfolioId;
    }

    public static void setPortfolioId(Long portfolioId) {
        Portfolio.portfolioId = portfolioId;
    }
}
