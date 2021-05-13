package vgvr.stocksapp.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vgvr.stocksapp.model.*;
import vgvr.stocksapp.service.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class CompanyController {

    public final StockChart stockChart = new StockChart();

    private final CompanyService companyService;
    private final AnnualStatisticsService annualStatisticsService;
    private final CashFlowsService cashFlowsService;
    private final MultipliersService multipliersService;
    @Autowired
    public CompanyController(CompanyService companyService, AnnualStatisticsService annualStatisticsService, CashFlowsService cashFlowsService, MultipliersService multipliersService) {
        this.companyService = companyService;
        this.annualStatisticsService = annualStatisticsService;
        this.cashFlowsService = cashFlowsService;
        this.multipliersService = multipliersService;
    }


    @GetMapping("/companies")
    public String findAll(Model model) throws IOException {
        List<Company> companies = companyService.findAll();
        List<Statistic> statistics = new ArrayList<>();
        for(Company company: companies){
            statistics.add(Statistic.getStatistic(company));
        }
        model.addAttribute("statistics",statistics);
        return "companies";
    }

    @GetMapping("company/{id}")
    public String viewCompany(@PathVariable("id") Long id,  Model model) throws IOException {
        companyService.findById(id);
        String ticker = companyService.findById(id).getTicker();
        List<StockChart> charts = stockChart.getStockData(ticker);
        List<AnnualStatistics> statistics = annualStatisticsService.findByCompany(id);
        List<CashFlows> flows = cashFlowsService.findByIdCompany(id);
        Stock stock = YahooFinance.get(ticker);
        model.addAttribute("stocksData", charts);
        model.addAttribute("annualStatistics",statistics );
        model.addAttribute("profitability", stock.getStats().getEpsEstimateCurrentYear());
        model.addAttribute("companyName", companyService.findById(id).getName() );
        model.addAttribute("multipliers", multipliersService.findByCompanyId(id) );
        model.addAttribute("flows", flows );
        return "company";
    }
    @GetMapping("/main")
    public String priceTable(Model model) throws IOException {
        List<Company> companies = companyService.findAll();
        List<Statistic> statisticsUp = new ArrayList<>();
        List<Statistic> statisticsDown = new ArrayList<>();
        for(Company company: companies){
            statisticsUp.add(Statistic.getStatistic(company));
            statisticsDown.add(Statistic.getStatistic(company));
        }

        Collections.sort(statisticsUp, new Comparator<Statistic>(){

            public int compare(Statistic o1, Statistic o2)
            {
                return o2.getChange().compareTo(o1.getChange());
            }
        });

        Collections.sort(statisticsDown, new Comparator<Statistic>(){

            public int compare(Statistic o1, Statistic o2)
            {
                return o1.getChange().compareTo(o2.getChange());
            }
        });

        System.out.println(statisticsDown.get(0).getChange());
        System.out.println(statisticsUp.get(0).getChange());

        statisticsUp = statisticsUp.subList(0,5);
        statisticsDown = statisticsDown.subList(0,5);

        model.addAttribute("statisticsUp",statisticsUp);
        model.addAttribute("statisticsDown",statisticsDown);
        return "main";
    }

    @GetMapping("/searchCompany")
    public String searchCompany(@PathVariable("id") Long id, Model model) throws IOException {
        model.addAttribute("status","search");
        Portfolio.setPortfolioId(id);
        Company company = new Company();
        model.addAttribute("company",company);
        return "newDeal";
    }

    @PostMapping("/searchCompany")
    public String addSearchCompany(Company company, Model model) throws IOException {
        model.addAttribute("company",company);
        Deal deal = new Deal();

        if(companyService.findByTicker(company.getTicker()).getId()!=null){
            model.addAttribute("status","add");

            Company.setCompanyId(companyService.findByTicker(company.getTicker()).getId());
            Statistic statistic = Statistic.getStatistic(companyService.findCompanyById(Company.getCompanyId()));
            model.addAttribute("stockPrice",statistic.getStockPrice());
            System.out.println(companyService.findCompanyById(Company.getCompanyId()));
            deal.setPrice(statistic.getStockPrice().doubleValue());
            model.addAttribute("deal",deal);
        }
        else{
            model.addAttribute("status","notFound");
        }
        return "newDeal";
    }

    @PostMapping("/findCompany")
    public String findCompany(Company company, Model model) throws IOException {
        model.addAttribute("companyForSearch",company);
        model.addAttribute("idCompany",companyService.findByTicker(company.getTicker()).getId());
        if(companyService.findByTicker(company.getTicker()).getId()!=null){
            model.addAttribute("status","success");
        }else{
            model.addAttribute("status","notFound");
        }

        return "company";
    }
}
