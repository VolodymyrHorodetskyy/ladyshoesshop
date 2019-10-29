package ua.com.ladyshoes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.notEmpty;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.IdHolder;
import ua.com.ladyshoes.entity.InputFinanceRecord;
import ua.com.ladyshoes.entity.InputFinanceType;
import ua.com.ladyshoes.repository.FinanceReasonRepository;
import ua.com.ladyshoes.request.AddInputFinanceRecordRequest;
import ua.com.ladyshoes.service.FinanceService;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LadyshoesApplicationTests {

    @Autowired
    private FinanceService financeService;

    @Autowired
    private FinanceReasonRepository reasonRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void addRecordTest() {
        List<FinanceReason> reasonsList = reasonRepository.findAll();
        double amount = 120;
        financeService.addRecord(new AddInputFinanceRecordRequest(amount, InputFinanceType.INCOME, reasonsList.stream().map(IdHolder::getId).collect(Collectors.toList())));
        financeService.addRecord(new AddInputFinanceRecordRequest(amount, InputFinanceType.INCOME, reasonsList.stream().map(IdHolder::getId).collect(Collectors.toList())));
        financeService.addRecord(new AddInputFinanceRecordRequest(amount, InputFinanceType.INCOME, reasonsList.stream().map(IdHolder::getId).collect(Collectors.toList())));
        List<InputFinanceRecord> records = financeService.getAllRecords();
        for (InputFinanceRecord financeRecord : records) {
            assertNotNull(financeRecord.getReasons());
            notEmpty(financeRecord.getReasons());
        }
    }

}
