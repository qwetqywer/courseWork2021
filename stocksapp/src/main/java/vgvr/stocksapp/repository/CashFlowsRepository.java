package vgvr.stocksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgvr.stocksapp.model.CashFlows;

import java.util.List;

public interface CashFlowsRepository extends JpaRepository<CashFlows, Long> {
    public List<CashFlows> findAllByIdcompany(Long id);
}
