package vgvr.stocksapp.service;

import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.AnnualStatistics;
import vgvr.stocksapp.repository.AnnualStatisticsRepository;

import java.util.List;

@Service
public class AnnualStatisticsService {
    private final AnnualStatisticsRepository annualStatisticsRepository;

    public AnnualStatisticsService(AnnualStatisticsRepository annualStatisticsRepository) {
        this.annualStatisticsRepository = annualStatisticsRepository;
    }

    public List<AnnualStatistics> findByCompany(Long id){
        return annualStatisticsRepository.findAllByIdCompany(id);
    }

}
