package vgvr.stocksapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vgvr.stocksapp.model.Company;
import vgvr.stocksapp.model.Portfolio;
import vgvr.stocksapp.model.User;
import vgvr.stocksapp.service.CompanyService;
import vgvr.stocksapp.service.PortfolioService;

import java.io.IOException;
import java.util.List;

@Controller
public class PortfolioController {

    private final PortfolioService portfolioService;
    @Autowired
    public PortfolioController(PortfolioService portfolioService, CompanyService companyService) {
        this.portfolioService = portfolioService;
        this.companyService = companyService;
    }
    private final CompanyService companyService;

    @GetMapping("/portfolio-deal/{id}")
    public String newDeal(@PathVariable("id") Long id, Model model) throws IOException {
        model.addAttribute("status","search");
        Portfolio.setPortfolioId(id);
        Company company1 = new Company();
        List<Company> companyList = companyService.findAll();
        model.addAttribute("statistics",companyList);
        model.addAttribute("company",company1);
        return "newDeal";
    }

    @GetMapping("/portfolio-deals/{id}")
    public String viewDeals(@PathVariable("id") Long id, Model model) throws IOException {
        Portfolio.setPortfolioId(id);
        System.out.println("портфель айди" + Portfolio.getPortfolioId());
        return "deals";
    }

    @GetMapping("/portfolios")
    public String findAll(Model model) throws IOException {
        List<Portfolio> portfoliosALL = portfolioService.findAllByUserId(User.getIdUser());
        model.addAttribute("portfoliosALL",portfoliosALL);
        System.out.println("size: " + portfoliosALL.size());
        return "portfolios";
    }

    @GetMapping("/newPortfolio")
    public String signUpForm(Portfolio portfolio, Model model){
        model.addAttribute("status","register");
        return "newPortfolio";
    }

    @PostMapping("/newPortfolio")
    public String savePortfolio(Portfolio portfolio, Model model){
        portfolio.generateUniqueName(portfolio.getName());
        portfolio.setUserId(User.getIdUser());
        portfolioService.save(portfolio);
        model.addAttribute("status","saved");
        System.out.println("saved");
        return "newPortfolio";
    }

    @GetMapping("portfolio-delete/{id}")
    public String deletePortfolio(@PathVariable("id") Long id, Model model){
        portfolioService.deleteById(id);
        List<Portfolio> portfoliosALL = portfolioService.findAllByUserId(User.getIdUser());
        model.addAttribute("portfoliosALL",portfoliosALL);
        return "portfolios";
    }

}
