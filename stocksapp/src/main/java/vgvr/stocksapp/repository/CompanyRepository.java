package vgvr.stocksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgvr.stocksapp.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyByTicker(String ticker);
    Company findCompanyById(Long id);
}
