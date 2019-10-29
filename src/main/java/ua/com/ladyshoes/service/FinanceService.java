package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceRecord;
import ua.com.ladyshoes.repository.FinanceReasonRepository;
import ua.com.ladyshoes.repository.FinanceRepository;
import ua.com.ladyshoes.request.AddInputFinanceRecordRequest;

import java.util.List;

@Service
public class FinanceService {

    private FinanceRepository financeRepository;
    private FinanceReasonRepository reasonRepository;

    public FinanceService(FinanceRepository financeRepository, FinanceReasonRepository reasonRepository) {
        this.financeRepository = financeRepository;
        this.reasonRepository = reasonRepository;
    }

    public InputFinanceRecord addRecord(AddInputFinanceRecordRequest recordRequest) {
        List<FinanceReason> reasons = reasonRepository.findAllById(recordRequest.getReasonsIds());
        InputFinanceRecord inputFinanceRecord = new InputFinanceRecord(recordRequest.getAmount(), recordRequest.getType());
        inputFinanceRecord.setReasons(reasons);
        return financeRepository.save(inputFinanceRecord);
    }

    public List<InputFinanceRecord> getAllRecords() {
        return financeRepository.findAll();
    }

}
