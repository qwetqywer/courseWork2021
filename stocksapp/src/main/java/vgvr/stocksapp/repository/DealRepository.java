package vgvr.stocksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgvr.stocksapp.model.Deal;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal,Long> {
    List<Deal> findAllByPortfolioId(Long portfolioId);
}
