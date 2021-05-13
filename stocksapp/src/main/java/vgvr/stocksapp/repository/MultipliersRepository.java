package vgvr.stocksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vgvr.stocksapp.model.Multipliers;

import java.util.List;

public interface MultipliersRepository extends JpaRepository<Multipliers, Long> {
    public List<Multipliers> findAllByIdcompany(Long id);
}
