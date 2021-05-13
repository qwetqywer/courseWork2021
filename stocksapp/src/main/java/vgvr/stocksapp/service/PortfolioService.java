package vgvr.stocksapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.Portfolio;
import vgvr.stocksapp.repository.PortfolioRepository;

import java.util.List;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public void deleteById(Long id){
        portfolioRepository.deleteById(id);
    }
    public List<Portfolio> findAll(){
        return portfolioRepository.findAll();
    }

    public Portfolio findById(Long id){
        return portfolioRepository.getOne(id);
    }

    public void save(Portfolio portfolio){
        portfolioRepository.save(portfolio);
    }

    public Portfolio findByUniqueName(Portfolio portfolio){
        return portfolioRepository.findPortfolioByUniqueName(portfolio.getUniqueName());
    }

    public List<Portfolio> findAllByUserId(Long id){
        return portfolioRepository.findAllByUserId(id);
    }
}
