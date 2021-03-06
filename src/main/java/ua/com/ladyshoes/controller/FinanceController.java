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
@CrossOrigin
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

    @GetMapping("/{id}")
    public InputFinanceRecord getFinanceRecord(@PathVariable Long id) {
        return financeService.getFinanceRecordById(id);
    }

    @DeleteMapping("/{id}")
    public InputFinanceRecord removeFinanceRecord(@PathVariable Long id) {
        return financeService.removeFinanceRecord(id);
    }

    @GetMapping("/reasons")
    public List<FinanceReason> getReasons(@RequestParam InputFinanceType inputFinanceType) {
        return reasonService.getFinanceReasons(inputFinanceType);
    }

    @GetMapping("/currentSum")
    public Double getCurrentSum() {
        return financeService.calculateCurrentSum();
    }

}
