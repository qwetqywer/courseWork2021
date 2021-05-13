package vgvr.stocksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgvr.stocksapp.model.Portfolio;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    Portfolio findPortfolioByUniqueName(String uniqueName);
    List<Portfolio> findAllByUserId(Long id);

}
