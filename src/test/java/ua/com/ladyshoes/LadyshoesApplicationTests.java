package ua.com.ladyshoes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.ladyshoes.entity.*;
import ua.com.ladyshoes.repository.FinanceReasonRepository;
import ua.com.ladyshoes.request.AddInputFinanceRecordRequest;
import ua.com.ladyshoes.service.FinanceService;
import ua.com.ladyshoes.service.ShoeService;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.util.Assert.notEmpty;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class LadyshoesApplicationTests {

    @Autowired
    private FinanceService financeService;

    @Autowired
    private FinanceReasonRepository reasonRepository;

    @Autowired
    private ShoeService shoeService;

    @Before
    public void setUp() {
    }

    @Test
    public void addRecordTest() {
        List<FinanceReason> reasonsList = reasonRepository.findAll();
        double amount = 120;
        Shoe shoe = shoeService.addShoe(new Shoe("999model", 999));
        financeService.addRecord(new AddInputFinanceRecordRequest(amount, InputFinanceType.INCOME, reasonsList.stream().map(IdHolder::getId).collect(Collectors.toList()), shoe.getModel()));
        financeService.addRecord(new AddInputFinanceRecordRequest(amount, InputFinanceType.INCOME, reasonsList.stream().map(IdHolder::getId).collect(Collectors.toList()), shoe.getModel()));
        financeService.addRecord(new AddInputFinanceRecordRequest(amount, InputFinanceType.INCOME, reasonsList.stream().map(IdHolder::getId).collect(Collectors.toList()), shoe.getModel()));
        List<InputFinanceRecord> records = financeService.getAllRecords();
        for (InputFinanceRecord financeRecord : records) {
            assertNotNull(financeRecord.getReasons());
            assertNotNull(financeRecord.getShoe());
            assertEquals(financeRecord.getShoe(), shoe);
            notEmpty(financeRecord.getReasons());
        }
    }

}
