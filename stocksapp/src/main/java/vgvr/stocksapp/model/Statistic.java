package vgvr.stocksapp.model;

import lombok.Data;
import lombok.Getter;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Data
@Getter
public class Statistic {

    private Long companyId;
    private String companyTicker;
    private BigDecimal stockPrice; /*цена акции*/
    private Long stockAmount; /*количество акций*/
    private BigDecimal capitalization; /*капитализация*/
    private BigDecimal enterpriseValue; /*стоимость компании*/
    private BigDecimal netDebt; /*чистый долг*/
    private BigDecimal totalCash; /*общее число денежных средств*/
    private BigDecimal totalCashPerShare; /*общее число денежных средств на акцию*/
    private BigDecimal totalDebt; /*общий долг*/
    private BigDecimal totalDebtEquity; /*общий долг на акцию*/
    private BigDecimal currentRatio; /*коэффициент тока*/
    private BigDecimal bookValuePerShare; /*Балансовая Стоимость На Акцию (mrq)*/
    private BigDecimal grossProfit; /*Валовая прибыль (ttm)*/
    private BigDecimal netProfit; /*Чистая прибыль (ttm)*/
    private BigDecimal revenue; /*Выручка*/
    private BigDecimal revenuePerShare; /*Выручка на акцию*/
    private BigDecimal incomeAviCommon; /*Чистая прибыль по сравнению с обычной (ttm)*/
    private BigDecimal ROE; /*Рентабельность собственного капитала*/
    private BigDecimal ROA; /*Рентабельность активов*/
    private BigDecimal change; /*изменения*/

    private BigDecimal EBITDA; /*рентабильность по EBITDA (процент от выручке до уплаты налогов)*/

    private BigDecimal PE; /*капитализация:прибыль*/
    private BigDecimal EP; /*прибыль:капитализацию*/
    private BigDecimal PS; /*цена акции: выручку*/
    private BigDecimal PB; /*цена акции: балансовая стоимость*/
    private BigDecimal NetDebt_EBITDA;

    public Statistic(Builder builder) {
        companyId = builder.companyId;
        companyTicker = builder.companyTicker;
        stockPrice = builder.stockPrice;
        stockAmount = builder.stockAmount;
        capitalization = builder.capitalization;
        enterpriseValue = builder.enterpriseValue;
        netDebt = builder.netDebt;
        totalCash = builder.totalCash;
        totalCashPerShare = builder.totalCashPerShare;
        totalDebt = builder.totalDebt;
        totalDebtEquity = builder.totalDebtEquity;
        currentRatio = builder.currentRatio;
        bookValuePerShare =builder.bookValuePerShare;
        grossProfit = builder.grossProfit;
        netProfit = builder.netProfit;
        NetDebt_EBITDA = builder.NetDebt_EBITDA;
        PB = builder.PB;
        PS = builder.PS;
        EP = builder.EP;
        PE = builder.PE;
        EBITDA = builder.EBITDA;
        change = builder.change;
        ROA = builder.ROA;
        ROE = builder.ROE;
        incomeAviCommon = builder.incomeAviCommon;
        revenuePerShare = builder.revenuePerShare;
        revenue = builder.revenue;

    }

    public Statistic() {

    }

    public int compareTo(Statistic o) {

        return toString().compareTo(o.toString());
    }

    public static Statistic getStatistic(Company company) throws IOException {
        Statistic statistic = new Statistic();

        Stock stock = YahooFinance.get(company.getTicker());

        statistic.setCompanyId(company.getId());
        statistic.setCompanyTicker(company.getName());
        statistic.setCapitalization(stock.getStats().getMarketCap());
        statistic.setPE(stock.getStats().getPe());
        statistic.setPB(stock.getStats().getPriceBook());
        statistic.setStockPrice(stock.getQuote().getPrice());
        statistic.setChange(stock.getQuote().getChange());
        statistic.setStockAmount(stock.getStats().getSharesOutstanding());

        return statistic;
    }

    public static class Builder {
        private final Long companyId;

        private String companyTicker;
        private BigDecimal stockPrice; /*цена акции*/
        private Long stockAmount; /*количество акций*/
        private BigDecimal capitalization; /*капитализация*/
        private BigDecimal enterpriseValue; /*стоимость компании*/
        private BigDecimal netDebt; /*чистый долг*/
        private BigDecimal totalCash; /*общее число денежных средств*/
        private BigDecimal totalCashPerShare; /*общее число денежных средств на акцию*/
        private BigDecimal totalDebt; /*общий долг*/
        private BigDecimal totalDebtEquity; /*общий долг на акцию*/
        private BigDecimal currentRatio; /*коэффициент тока*/
        private BigDecimal bookValuePerShare; /*Балансовая Стоимость На Акцию (mrq)*/
        private BigDecimal grossProfit; /*Валовая прибыль (ttm)*/
        private BigDecimal netProfit; /*Чистая прибыль (ttm)*/
        private BigDecimal revenue; /*Выручка*/
        private BigDecimal revenuePerShare; /*Выручка на акцию*/
        private BigDecimal incomeAviCommon; /*Чистая прибыль по сравнению с обычной (ttm)*/
        private BigDecimal ROE; /*Рентабельность собственного капитала*/
        private BigDecimal ROA; /*Рентабельность активов*/
        private BigDecimal change; /*изменения*/

        private BigDecimal EBITDA; /*рентабильность по EBITDA (процент от выручке до уплаты налогов)*/

        private BigDecimal PE; /*капитализация:прибыль*/
        private BigDecimal EP; /*прибыль:капитализацию*/
        private BigDecimal PS; /*цена акции: выручку*/
        private BigDecimal PB; /*цена акции: балансовая стоимость*/
        private BigDecimal NetDebt_EBITDA;

        public Builder(Long id) {
            this.companyId = id;
        }


        public Builder totalDebtEquity(BigDecimal val) {
            this.totalDebtEquity = val;
            return this;
        }
        public Builder totalCashPerShare(BigDecimal val) {
            this.totalCashPerShare = val;
            return this;
        }
        public Builder PE(BigDecimal val) {
            this.PE = val;
            return this;
        }
        public Builder change(BigDecimal val) {
            this.change = val;
            return this;
        }
        public Builder companyTicker(String val) {
            this.companyTicker = val;
            return this;
        }
        public Builder enterpriseValue(BigDecimal val) {
            this.enterpriseValue = val;
            return this;
        }

        public Builder capitalization(BigDecimal val) {
            this.capitalization = val;
            return this;
        }
        public Builder stockAmount(Long val) {
            this.stockAmount = val;
            return this;
        }
        public Builder stockPrice(BigDecimal val) {
            this.stockPrice = val;
            return this;
        }
        public Builder totalCash(BigDecimal val) {
            this.totalCash = val;
            return this;
        }
        public Builder netDebt(BigDecimal val) {
            this.netDebt = val;
            return this;
        }
        public Builder totalDebt(BigDecimal val) {
            this.totalDebt = val;
            return this;
        }
        public Builder grossProfit(BigDecimal val) {
            this.grossProfit = val;
            return this;
        }
        public Builder bookValuePerShare(BigDecimal val) {
            this.bookValuePerShare = val;
            return this;
        }
        public Builder currentRatio(BigDecimal val) {
            this.currentRatio = val;
            return this;
        }
        public Builder revenuePerShare(BigDecimal val) {
            this.revenuePerShare = val;
            return this;
        }
        public Builder revenue(BigDecimal val) {
            this.revenue = val;
            return this;
        }
        public Builder ROA(BigDecimal val) {
            this.ROA = val;
            return this;
        }
        public Builder netProfit(BigDecimal val) {
            this.netProfit = val;
            return this;
        }
        public Builder ROE(BigDecimal val) {
            this.ROE = val;
            return this;
        }
        public Builder incomeAviCommon(BigDecimal val) {
            this.incomeAviCommon = val;
            return this;
        }
        public Builder EBITDA(BigDecimal val) {
            this.EBITDA = val;
            return this;
        }

        public Builder NetDebt_EBITDA(BigDecimal val) {
            this.NetDebt_EBITDA = val;
            return this;
        }

        public Builder EP(BigDecimal val) {
            this.EP = val;
            return this;
        }

        public Builder PS(BigDecimal val) {
            this.PS = val;
            return this;
        }

        public Builder PB(BigDecimal val) {
            this.PB = val;
            return this;
        }

        public Statistic build() {
            return new Statistic(this);
        }
    }


}