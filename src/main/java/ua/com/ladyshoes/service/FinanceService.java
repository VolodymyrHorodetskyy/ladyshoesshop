package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceRecord;
import ua.com.ladyshoes.entity.Shoe;
import ua.com.ladyshoes.repository.FinanceReasonRepository;
import ua.com.ladyshoes.repository.FinanceRepository;
import ua.com.ladyshoes.repository.ShoeRepository;
import ua.com.ladyshoes.request.AddInputFinanceRecordRequest;

import java.util.List;

@Service
public class FinanceService {

    private FinanceRepository financeRepository;
    private FinanceReasonRepository reasonRepository;
    private ShoeRepository shoeRepository;

    public FinanceService(FinanceRepository financeRepository, FinanceReasonRepository reasonRepository, ShoeRepository shoeRepository) {
        this.financeRepository = financeRepository;
        this.reasonRepository = reasonRepository;
        this.shoeRepository = shoeRepository;
    }

    public InputFinanceRecord addRecord(AddInputFinanceRecordRequest recordRequest) {
        List<FinanceReason> reasons = null;
        if (!CollectionUtils.isEmpty(recordRequest.getReasonsIds())) {
            reasons = reasonRepository.findAllById(recordRequest.getReasonsIds());
        }
        String model = recordRequest.getModel();
        Shoe shoe = null;
        if (model != null) {
            List<Shoe> shoes = shoeRepository.findByModel(model);
            if (!CollectionUtils.isEmpty(shoes)) {
                shoe = shoes.get(0);
            }
        }
        InputFinanceRecord inputFinanceRecord = new InputFinanceRecord(recordRequest.getAmount(), recordRequest.getType(), shoe);
        inputFinanceRecord.setReasons(reasons);
        return financeRepository.save(inputFinanceRecord);
    }

    public List<InputFinanceRecord> getAllRecords() {
        return financeRepository.findByRemovedFalse();
    }

    public InputFinanceRecord getFinanceRecordById(Long id) {
        return financeRepository.findById(id).orElse(null);
    }

}
