package ua.com.ladyshoes.controller;

import org.springframework.web.bind.annotation.*;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceRecord;
import ua.com.ladyshoes.entity.InputFinanceType;
import ua.com.ladyshoes.request.AddInputFinanceRecordRequest;
import ua.com.ladyshoes.service.FinanceReasonService;
import ua.com.ladyshoes.service.FinanceService;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    private FinanceService financeService;
    private FinanceReasonService reasonService;

    public FinanceController(FinanceService financeService, FinanceReasonService reasonService) {
        this.financeService = financeService;
        this.reasonService = reasonService;
    }

    @PostMapping
    public InputFinanceRecord addRecord(@RequestBody AddInputFinanceRecordRequest request) {
        return financeService.addRecord(request);
    }

    @GetMapping
    public List<InputFinanceRecord> getAllRecords() {
        return financeService.getAllRecords();
    }

    @GetMapping("/reasons")
    public List<FinanceReason> getReasons(@RequestParam InputFinanceType inputFinanceType) {
        return reasonService.getFinanceReasons(inputFinanceType);
    }

}
