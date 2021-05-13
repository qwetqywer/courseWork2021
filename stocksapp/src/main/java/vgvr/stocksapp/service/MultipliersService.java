package vgvr.stocksapp.service;

import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.Multipliers;
import vgvr.stocksapp.repository.MultipliersRepository;

import java.util.List;

@Service
public class MultipliersService {
    private final MultipliersRepository multipliersRepository;

    public MultipliersService(MultipliersRepository multipliersRepository) {
        this.multipliersRepository = multipliersRepository;
    }

    public List<Multipliers> findByCompanyId(Long id){
        return multipliersRepository.findAllByIdcompany(id);
    }
}
