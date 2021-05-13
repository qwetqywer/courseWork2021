package vgvr.stocksapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vgvr.stocksapp.model.Company;
import vgvr.stocksapp.model.Deal;
import vgvr.stocksapp.model.Portfolio;
import vgvr.stocksapp.model.User;
import vgvr.stocksapp.repository.CompanyRepository;
import vgvr.stocksapp.service.DealService;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.List;

@Controller
public class DealController {
    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService, CompanyRepository companyRepository) {
        this.dealService = dealService;
    }

    @GetMapping("/deals")
    public String findAll(Model model) throws IOException {
        System.out.println("setport: " +Portfolio.getPortfolioId());
        List<Deal> deals = dealService.findAllByPortfolioId(Portfolio.getPortfolioId());
        System.out.println(User.getIdUser());
        System.out.println(Portfolio.getPortfolioId());
        model.addAttribute("deals",deals);
        return "/deals";
    }

    @GetMapping("/newDeal")
    public String signUpForm(Deal deal, Model model){
        System.out.println("hi");
        //model.addAttribute("addStatus","register");
        model.addAttribute("deal",deal);
        model.addAttribute("portfolioID", Portfolio.getPortfolioId());
        return "/newDeal";
    }

    @PostMapping("/newDeal")
    public String saveDeal(Deal deal, Model model){

        deal.setUserId(User.getIdUser());
        deal.setCompanyId(Company.getCompanyId());
        System.out.println(deal.getUserId());
        System.out.println(deal.getCompanyId());
        deal.setPortfolioId(Portfolio.getPortfolioId());
        System.out.println(deal);
        dealService.save(deal);
        //model.addAttribute("deal",deal);
        //model.addAttribute("portfolioID", Portfolio.getPortfolioId());
        model.addAttribute("status","saved");
        System.out.println("saved");
        return "/newDeal";
    }

    @GetMapping("deal-delete/{id}")
    public String deletePortfolio(@PathVariable("id") Long id, Model model){
        dealService.deleteById(id);
        List<Deal> deals = dealService.findAllByPortfolioId(Portfolio.getPortfolioId());
        System.out.println(User.getIdUser());
        System.out.println(Portfolio.getPortfolioId());
        model.addAttribute("deals",deals);
        return "/deals";
    }

    @GetMapping("deals-portfolio/{id}")
    public String viewDeals(@PathVariable("id") Long id, Model model){
        System.out.println("setport: " +Portfolio.getPortfolioId());
        Portfolio.setPortfolioId(id);
        List<Deal> deals = dealService.findAllByPortfolioId(id);
        model.addAttribute("deals",deals);
        return "/deals";
    }

}
