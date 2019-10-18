package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceType;
import ua.com.ladyshoes.repository.FinanceReasonRepository;

import java.util.List;

@Service
public class FinanceReasonService {

    private FinanceReasonRepository reasonRepository;

    public FinanceReasonService(FinanceReasonRepository reasonRepository) {
        this.reasonRepository = reasonRepository;
    }

    public FinanceReason addFinanceReason(FinanceReason financeReason){
        return reasonRepository.save(financeReason);
    }

    public List<FinanceReason> getFinanceReasons(InputFinanceType type){
         return reasonRepository.findByType(type);
    }

}
