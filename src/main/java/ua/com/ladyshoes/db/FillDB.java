package ua.com.ladyshoes.db;

import org.springframework.stereotype.Component;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceType;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.service.FinanceReasonService;
import ua.com.ladyshoes.service.ItemService;

import javax.annotation.PostConstruct;

@Component
public class FillDB {

    private ItemService itemService;
    private FinanceReasonService reasonService;

    public FillDB(ItemService itemService, FinanceReasonService reasonService) {
        this.itemService = itemService;
        this.reasonService = reasonService;
    }

    @PostConstruct
    public void init() {
        itemService.createItem(new Item("Взуття кросівки"));
        reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "передпалата", "олх"));
    }

}
