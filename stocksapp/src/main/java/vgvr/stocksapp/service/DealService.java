package vgvr.stocksapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vgvr.stocksapp.model.Deal;
import vgvr.stocksapp.repository.DealRepository;

import java.util.List;

@Service
public class DealService {
    private final DealRepository dealRepository;

    @Autowired
    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public void deleteById(Long id){
        dealRepository.deleteById(id);
    }
    public List<Deal> findAll(){
        return dealRepository.findAll();
    }

    public Deal findById(Long id){
        return dealRepository.getOne(id);
    }

    public void save(Deal deal){
        dealRepository.save(deal);
    }

    public List<Deal> findAllByPortfolioId(Long id){
        return dealRepository.findAllByPortfolioId(id);
    }
}
