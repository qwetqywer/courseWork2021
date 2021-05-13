package vgvr.stocksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgvr.stocksapp.model.AnnualStatistics;

import java.util.List;

public interface AnnualStatisticsRepository extends JpaRepository<AnnualStatistics, Long> {
    List<AnnualStatistics> findAllByIdCompany(Long idCompany);
}
