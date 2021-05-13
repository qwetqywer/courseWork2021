package vgvr.stocksapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.Company;
import vgvr.stocksapp.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        return companyRepository.getOne(id);
    }

    public Company findByTicker(String ticker){
        return companyRepository.findCompanyByTicker(ticker);
    }
    public Company findCompanyById(Long id){
        return companyRepository.findCompanyById(id);
    }
}
