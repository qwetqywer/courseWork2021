package vgvr.stocksapp.service;

import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.CashFlows;
import vgvr.stocksapp.repository.CashFlowsRepository;

import java.util.List;


@Service
public class CashFlowsService {
    private final CashFlowsRepository cashFlowsRepository;

    public CashFlowsService(CashFlowsRepository cashFlowsRepository) {
        this.cashFlowsRepository = cashFlowsRepository;
    }

    public List<CashFlows> findByIdCompany(Long id){
        return cashFlowsRepository.findAllByIdcompany(id);
    }
}
